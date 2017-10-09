import java.util.Locale;
import java.util.Scanner;

public class Ex06_MaxSequenceInMatrix_20Jan2016 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        int maxSequence = Integer.MIN_VALUE;

        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentRow = row;
                int currentCol = col;
                int currentSequence = 1;

                while (currentCol < cols - 1 && matrix[currentRow][currentCol].equals(matrix[currentRow][currentCol + 1])) {
                    currentSequence++;
                    if (currentSequence > maxSequence) {
                        maxSequence = currentSequence;
                        maxRow = currentRow;
                        maxCol = currentCol;
                    }
                    currentCol++;
                }

                currentRow = row;
                currentCol = col;
                currentSequence = 1;
                while (currentRow < rows - 1 && matrix[currentRow][currentCol].equals(matrix[currentRow + 1][currentCol])) {
                    currentSequence++;
                    if (currentSequence >= maxSequence) {
                        maxSequence = currentSequence;
                        maxRow = currentRow;
                        maxCol = currentCol;
                    }
                    currentRow++;
                }

                currentRow = row;
                currentCol = col;
                currentSequence = 1;
                while (currentRow < rows - 1 && currentCol < cols - 1 && matrix[currentRow][currentCol].equals(matrix[currentRow + 1][currentCol + 1])) {
                    currentSequence++;
                    if (currentSequence > maxSequence) {
                        maxSequence = currentSequence;
                        maxRow = currentRow;
                        maxCol = currentCol;
                    }
                    currentRow++;
                    currentCol++;
                }
            }
        }

        String maxString = matrix[maxRow][maxCol];

        for (int i = 0; i < maxSequence; i++) {
            System.out.print(maxString + ", ");
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] remainders = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = remainders[col];
            }
        }
    }
}




// Input1
//3 4
//ha fifi ho hi
//fo ha hi xx
//xxx ho ha xx

// Input2
//3 3
//s qq s
//pp pp s
//pp qq s


//Solution giving 80/100
//Locale.setDefault(Locale.ROOT);
//        Scanner scan = new Scanner(System.in);
//
//        String[] matrixSize = scan.nextLine().split("\\s");
//        int rows = Integer.parseInt(matrixSize[0]);
//        int cols = Integer.parseInt(matrixSize[1]);
//
//        String[][] matrix = new String[rows][cols];
//        int maxSequence = Integer.MIN_VALUE;
//        int[] maxRowCol = {0, 0};
//
//
//        //Filling the matrix
//        for (int rowFill = 0; rowFill < rows; rowFill++) {
//        String[] currentRow = scan.nextLine().split("\\s");
//        for (int colFill = 0; colFill < cols; colFill++) {
//        matrix[rowFill][colFill] = currentRow[colFill];
//        }
//        }
//
//        for (int row = 0; row < rows; row++) {
//        for (int col = 0; col < cols; col++) {
//        int currentRow = row;
//        int currentCol = col;
//        int currentSequence = 1;
//
//        //Check the rows
//        while(currentCol < cols - 1
//        && matrix[currentRow][currentCol]
//        .equals(matrix[currentRow][currentCol + 1])){
//        currentSequence++;
//        if(currentSequence > maxSequence){
//        maxSequence = currentSequence;
//        maxRowCol[0] = currentRow;
//        maxRowCol[1] = currentCol;
//        }
//        currentCol++;
//        }
//
//
//        //Check the cols
//        currentRow = row;
//        currentCol = col;
//        currentSequence = 1;
//        while(currentRow < rows - 1
//        && matrix[currentRow][currentCol]
//        .equals(matrix[currentRow + 1][currentCol])){
//        currentSequence++;
//        if(currentSequence > maxSequence){
//        maxSequence = currentSequence;
//        maxRowCol[0] = currentRow;
//        maxRowCol[1] = currentCol;
//        }
//        currentRow++;
//        }
//
//        //Check the diagonals
//        currentRow = row;
//        currentCol = col;
//        currentSequence = 1;
//        while (currentRow < rows - 1 && currentCol < cols - 1
//        && matrix[currentRow][currentCol]
//        .equals(matrix[currentRow + 1][currentCol + 1])){
//        currentSequence++;
//        if (currentSequence > maxSequence){
//        maxSequence = currentSequence;
//        maxRowCol[0] = currentRow;
//        maxRowCol[1] = currentCol;
//        }
//        currentRow++;
//        currentCol++;
//        }
//
//        }
//        }
//
//        String maxString = matrix[maxRowCol[0]][maxRowCol[1]];
//
//        for (int i = 0; i < maxSequence; i++) {
//        System.out.print(maxString + ", ");
//        }