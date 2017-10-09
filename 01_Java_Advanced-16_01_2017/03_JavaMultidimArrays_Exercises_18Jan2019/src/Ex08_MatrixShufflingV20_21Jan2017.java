import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Ivan Minchev on 1/24/2017.
 */
public class Ex08_MatrixShufflingV20_21Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scan = new Scanner(System.in);
        String[] matrixSize = scan.nextLine().split("\\s");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        String[][] matrix = fillTheMatrix(scan, rows, cols);
        String commands = scan.nextLine();

        while(!commands.equals("END")) {
            String[] data = commands.split("\\s");
            if(data.length == 5){
                String action = data[0];
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);
                if(action.equals("swap") && row1 < rows && row2 < rows && col1 < cols && col2 < cols) {
                    matrix = swapItems(data, matrix, rows, cols, row1, col1, row2, col2);
                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            commands = scan.nextLine();
        }
    }

    private static String[][] swapItems(String[] commands, String[][] matrix, int rows, int cols, int row1, int col1, int row2, int col2) {
        String[][] swapMatrix = matrix;
        String temp = matrix[row1][col1];
        swapMatrix[row1][col1] = matrix[row2][col2];
        swapMatrix[row2][col2] = temp;
        swapMatrix[Integer.parseInt(commands[3])][Integer.parseInt(commands[4])] = temp;
        return swapMatrix;
    }

    private static String[][] fillTheMatrix(Scanner scan, int rows, int cols) {
        String[][] inputMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scan.nextLine().split("\\s");

            for (int col = 0; col < cols; col++) {
                inputMatrix[row][col] = currentRow[col];
            }
        }
        return inputMatrix;
    }
}

//Input
//2 3
//1 2 3
//4 5 6
//swap 0 0 1 1
//swap 10 9 8 7
//swap 0 1 1 0
//END
