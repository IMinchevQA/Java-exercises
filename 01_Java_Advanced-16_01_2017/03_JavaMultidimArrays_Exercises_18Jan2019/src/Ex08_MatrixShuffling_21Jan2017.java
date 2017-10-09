import java.util.Locale;
import java.util.Scanner;
public class Ex08_MatrixShuffling_21Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scan = new Scanner(System.in);
        String[] matrixSize = scan.nextLine().split("\\s");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        boolean stopCommandsTaking = false;


        String[][] matrix = fillTheMatrix(scan, rows, cols);

        do {
            String[] commands = scan.nextLine().split("\\s");
            if(commands[0].equals("swap")){
                try {
                    matrix = swapItems(commands, matrix);
                    //Print current matrix condition
                    for (String[] row : matrix) {
                        for (String item : row) {
                            System.out.print(item + " ");
                        }
                        System.out.println();
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid input!");
                }
            } else if(commands[0].equals("END")){
                stopCommandsTaking = true;
            } else {
                System.out.println("Invalid input!");
            }
        } while(stopCommandsTaking == false);
    }

    private static String[][] swapItems(String[] commands, String[][] matrix) {
        String[][] swapMatrix = matrix;
        String temp = matrix[Integer.parseInt(commands[1])][Integer.parseInt(commands[2])];
        swapMatrix[Integer.parseInt(commands[1])][Integer.parseInt(commands[2])] = swapMatrix[Integer.parseInt(commands[3])][Integer.parseInt(commands[4])];
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






//Solution failing on test 4

//import java.util.Locale;
//        import java.util.Scanner;
//
//
