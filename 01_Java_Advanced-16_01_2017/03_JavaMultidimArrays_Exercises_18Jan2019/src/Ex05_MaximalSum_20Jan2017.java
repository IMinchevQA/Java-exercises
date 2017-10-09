import java.util.Locale;
import java.util.Scanner;

public class Ex05_MaximalSum_20Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scan = new Scanner(System.in);

        String[] size = scan.nextLine().split("\\s");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        //int[][] maxSumMatrix = new int[3][3];

        int maxSum = Integer.MIN_VALUE;
        int[] maxMatrixStartIndexes = new int[2];

        //Filling up matrix
        for (int rowFill = 0; rowFill < rows; rowFill++) {
            String[] currentRow = scan.nextLine().split("\\s");
            for (int colFill = 0; colFill < cols; colFill++) {
                matrix[rowFill][colFill] = Integer.parseInt(currentRow[colFill]);
            }
        }

        //Search max sum
        for (int rowSum = 0; rowSum < rows - 2; rowSum++){
            for (int colSum = 0; colSum < cols - 2; colSum++){
                int currentSum = 0;
                currentSum += matrix[rowSum][colSum] + matrix[rowSum][colSum + 1] + matrix[rowSum][colSum + 2];
                currentSum += matrix[rowSum + 1][colSum] + matrix[rowSum + 1][colSum + 1] + matrix[rowSum + 1][colSum + 2];
                currentSum += matrix[rowSum + 2][colSum] + matrix[rowSum + 2][colSum + 1] + matrix[rowSum + 2][colSum + 2];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    maxMatrixStartIndexes[0] = rowSum;
                    maxMatrixStartIndexes[1] = colSum;
                }
            }
        }

        System.out.printf("Sum = %1$d",maxSum);
        System.out.println();

        //Printing out the max matrix
        for (int rowPrint = 0; rowPrint < 3; rowPrint++) {
            for (int colPrint = 0; colPrint < 3; colPrint++) {
                System.out.print(matrix[rowPrint + maxMatrixStartIndexes[0]][colPrint + maxMatrixStartIndexes[1]] + " ");
            }
            System.out.println();

        }
    }
}

//Input
//4 5
//        1 5 5 2 4
//        2 1 4 14 3
//        3 7 11 2 8
//        4 8 12 16 4
