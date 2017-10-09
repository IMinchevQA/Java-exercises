import java.util.Locale;
import java.util.Scanner;

public class Ex01_FillTheMatrix_20Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(input[0]);
        int[][] matrix = new int[matrixSize][matrixSize];
        String matrixType = input[1];
        int currentValue = 0;

        //Filing up the matrix
        switch(matrixType){
            case "A":
                currentValue = 0;
                for (int rowAFill = 0; rowAFill < matrixSize; rowAFill++) {
                    for (int colAFill = 0; colAFill < matrixSize; colAFill++) {
                        matrix[colAFill][rowAFill] = currentValue + 1;
                        currentValue = matrix[colAFill][rowAFill];
                    }

                }
                break;

            case "B":
                currentValue = 0;
                for (int rowBFill = 0; rowBFill < matrixSize; rowBFill++) {
                    if (rowBFill % 2 == 0){
                        for (int colBFill = 0; colBFill < matrixSize; colBFill++) {
                            matrix[colBFill][rowBFill] = currentValue + 1;
                            currentValue = matrix[colBFill][rowBFill];
                        }
                    } else if (rowBFill % 2 != 0){
                        for (int colBFill = matrixSize - 1; colBFill >= 0; colBFill--) {
                            matrix[colBFill][rowBFill] = currentValue + 1;
                            currentValue = matrix[colBFill][rowBFill];
                        }
                    }

                }
                break;
        }

        //Printing the result;
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}

//Input - '5, A' or '5, B'