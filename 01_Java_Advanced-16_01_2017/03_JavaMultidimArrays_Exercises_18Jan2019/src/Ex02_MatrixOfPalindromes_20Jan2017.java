import java.util.Locale;
import java.util.Scanner;

public class Ex02_MatrixOfPalindromes_20Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        
        String[] input = scanner.nextLine().split("\\s");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        
        String[][] matrix = new String[rows][cols];
        
        //Filing up the matrix
        for (int iRowFill = 0; iRowFill < rows; iRowFill++) {
            for (int iColFill = 0; iColFill < cols; iColFill++) {
                matrix[iRowFill][iColFill] = "" + (char)('a' + iRowFill) + (char)('a' + iRowFill + iColFill) + (char)('a' + iRowFill);
            }
        }

        //Printing out the result
        for (String[] row : matrix) {
            for (String palindrome : row) {
                System.out.print(palindrome + " ");
            }
            System.out.println();
        }
    }
}


//Input - '4 6'  or '3 2'