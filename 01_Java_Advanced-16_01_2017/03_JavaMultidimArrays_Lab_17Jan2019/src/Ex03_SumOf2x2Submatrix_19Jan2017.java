import java.util.Locale;
import java.util.Scanner;

public class Ex03_SumOf2x2Submatrix_19Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        String[] length = input.nextLine().split(", ");
        int rows = Integer.parseInt(length[0]);
        int cols = Integer.parseInt(length[1]);
        //Input matrix
        int[][] matrix = new int[rows][cols];
        int sumSubmatrix = Integer.MIN_VALUE;
        int[][] submatrix = new int[2][2];

        //Read the input matrix!!!
        for (int rowRead = 0; rowRead < rows; rowRead++) {
            String[] currentRow = input.nextLine().split(", ");
            for (int colRead = 0; colRead < cols; colRead++) {
                matrix[rowRead][colRead] = Integer.parseInt(currentRow[colRead]);
            }
        }

        //Sum 2 x 2 submatrix
        for (int rowSum = 0; rowSum < rows - 1; rowSum++) {
            int currentSum;
            for (int colSum = 0; colSum < cols - 1; colSum++) {
                currentSum = 0;
                currentSum += matrix[rowSum][colSum];
                currentSum += matrix[rowSum][colSum+1];
                currentSum += matrix[rowSum+1][colSum];
                currentSum += matrix[rowSum+1][colSum+1];
                if(currentSum > sumSubmatrix){
                    sumSubmatrix = currentSum;
                    submatrix[0][0] = matrix[rowSum][colSum];
                    submatrix[0][1] = matrix[rowSum][colSum+1];
                    submatrix[1][0] = matrix[rowSum+1][colSum];
                    submatrix[1][1] = matrix[rowSum+1][colSum+1];
                }
            }
        }

        //Printing output
        for (int[] row : submatrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println(sumSubmatrix);
    }
}