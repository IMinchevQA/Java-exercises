import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ivan Minchev on 9/20/2017.
 */
public class Ex01_Matrices {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] inputTokens = sc.nextLine().split("\\s+");
        String typeMatrix = inputTokens[0];
        int rows = Integer.valueOf(inputTokens[1]);
        int cols = Integer.valueOf(inputTokens[2]);
        int[][] result = new int[rows][cols];

        switch (typeMatrix) {
            case "A":
                result = createMatrixTypeA(rows, cols);
                break;
            case "B":
                result = createMatrixTypeB(rows, cols);
                break;
            case "C1":
                result = createMatrixTypeC1(rows, cols);
                break;
            case "C2":
                result = createMatrixTypeC2(rows, cols);
                break;
            case "C3":
                result = createMatrixTypeC3(rows, cols);
                break;
            case "C4":
                result = createMatrixTypeC4(rows, cols);
                break;
            case "D":
                result = createMatrixTypeD(rows, cols);
                break;
        }


        Arrays.stream(result).forEach(r -> {
            StringBuilder print = new StringBuilder();
            Arrays.stream(r).forEach(e -> print.append(e).append(" "));
            System.out.println(print.toString().trim());
        });

//        for (int i = 0; i < rows; i++) {
//            StringBuilder print = new StringBuilder();
//            for (int j = 0; j < cols; j++) {
//                print.append(result[i][j] + " ");
//            }
//            System.out.println(print.toString().trim());
//        }

    }

    private static int[][] createMatrixTypeD(int rows, int cols) {
        int[][] matrixD = new int[rows][cols];
        int minRow = 0;
        int maxRow = rows - 1;
        int minCol = 0;
        int maxCol = cols - 1;
        int direction = 1;
        int maxNumber = rows * cols;
        int currentNum = 1;

        while (currentNum <= maxNumber) {
            switch (direction) {
                //Top bottom
                case 1:
                    for (int row = minRow; row <= maxRow; row++) {
                        matrixD[row][minCol] = currentNum;
                        currentNum++;
                    }
                    minCol++;
                    direction = 2;
                    break;
                case 2:
                    for (int col = minCol; col <= maxCol; col++) {
                        matrixD[maxRow][col] = currentNum;
                        currentNum++;
                    }
                    maxRow--;
                    direction = 3;
                    break;
                case 3:
                    for (int row = maxRow; row >= minRow; row--) {
                        matrixD[row][maxCol] = currentNum;
                        currentNum++;
                    }
                    maxCol--;
                    direction = 4;
                    break;
                case 4:
                    for (int col = maxCol; col >= minCol; col--) {
                        matrixD[minRow][col] = currentNum;
                        currentNum++;
                    }
                    minRow++;
                    direction =1;
                    break;
            }
        }

        return matrixD;
    }

    private static int[][] createMatrixTypeC4(int rows, int cols) {
        int[][] matrixC4 = new int[rows][cols];
        int maxConstC4 = (rows - 1) + (cols - 1);
        int currentNum = 1;

        for (int row = (rows - 1); row >= (rows - 1) - maxConstC4; row--) {
            int colMin = Math.max(0, row + (cols - rows));
            int colMax = Math.min((cols - 1) + row, cols - 1);

            for (int col = colMax; col >= colMin; col--) {
                int rowToFill = row + ((cols - 1) - col);
                matrixC4[rowToFill][col] = currentNum;
                currentNum++;
            }
        }

        return matrixC4;
    }

    private static int[][] createMatrixTypeC3(int rows, int cols) {
        int[][] matrixC3 = new int[rows][cols];
        int maxConstC3 = (rows - 1) + (cols - 1);
        int currentNum = 1;

        for (int col = (cols - 1); col >= (cols - 1) - maxConstC3; col--) {
            int rowMin = Math.max(0, 0 - col);
            int rowMax = Math.min((cols - 1) - col, rows - 1);
            for (int row = rowMin; row <= rowMax; row++) {
                int colToFill = row + col;
                matrixC3[row][colToFill] = currentNum;
                currentNum++;
            }
        }

        return matrixC3;
    }

    private static int[][] createMatrixTypeC2(int rows, int cols) {
        int[][] matrixC2 = new int[rows][cols];
        int maxConstC2 = (rows - 1) + (cols - 1);
        int currentNum = 1;
        for (int col = 0; col <= maxConstC2; col++) {
            int rowMin = Math.max(0, col - (cols - 1));
            int rowMax = Math.min(col, rows - 1);
            for (int row = rowMin; row <= rowMax; row++) {
                int collToFill = col - row;
                matrixC2[row][collToFill] = currentNum;
                currentNum++;
            }
        }

        return matrixC2;
    }


    private static int[][] createMatrixTypeC1(int rows, int cols) {
        int[][] matrixC1 = new int[rows][cols];
        int maxConst = (rows - 1) + (cols - 1);
        int currentNum = 1;

        for (int row = (rows - 1); row >= ((rows - 1) - maxConst); row--) {
            int colMin = Math.max(0, 0 - row);
            int colMax = Math.min((rows - 1) - row, cols - 1);
            for (int col = colMin; col <= colMax; col++) {
                int rowToFill = row + col;
                matrixC1[rowToFill][col] = currentNum;
                currentNum++;
            }
        }

        return matrixC1;
    }

    private static int[][] createMatrixTypeB(int rows, int cols) {
        int[][] matrixB = new int[rows][cols];
        int currentNum = 1;
        for (int col = 0; col < cols; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < rows; row++) {
                    matrixB[row][col] = currentNum;
                    currentNum++;
                }
            } else {
                for (int row = rows - 1; row >= 0; row--) {
                    matrixB[row][col] = currentNum;
                    currentNum++;
                }
            }
        }
        return matrixB;
    }

    private static int[][] createMatrixTypeA(int rows, int cols) {
        int[][] matrixA = new int[rows][cols];
        int currentNum = 1;
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                matrixA[row][col] = currentNum;
                currentNum++;
            }
        }

        return matrixA;
    }

}

/*
Input 1:
A 4 4

Output 1:
1 5 9 13
2 6 10 14
3 7 11 15
4 8 12 16



Input 2:
B 3 2

Output 2:
1 6
2 5
3 4


Input 3:
C1 4 4

Output 3:
7 11 14 16
4 8 12 15
2 5 9 13
1 3 6 10

Input 4:
C2 4 4

Output 4:
1 2 4 7
3 5 8 11
6 9 12 14
10 13 15 16


Input 5:
C3 4 4

Output 5:
7 4 2 1
11 8 5 3
14 12 9 6
16 15 13 10


Input 6:
C4 4 4

Output 6:
16 14 11 7
15 12 8 4
13 9 5 2
10 6 3 1


Input 7:
D 3 4

Output 7:
1 10 9 8
2 11 12 7
3 4 5 6

*/
