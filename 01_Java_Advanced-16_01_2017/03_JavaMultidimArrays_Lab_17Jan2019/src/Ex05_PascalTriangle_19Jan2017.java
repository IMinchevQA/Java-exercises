import java.util.Locale;
import java.util.Scanner;

public class Ex05_PascalTriangle_19Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        int countRows = Integer.parseInt(input.nextLine());
        int intervalsCount = countRows - 1;

        //Declaring the Pascal's triangle.
        long[][] pascal = new long[countRows][];

        //Initializing the 'pascal' matrix's rows length
        for (int iLength = 0; iLength < countRows; iLength++) {
            pascal[iLength] = new long[iLength + 1];
        }

        pascal[0][0] = 1;

        for (int row = 1; row < countRows ; row++) {
            pascal[row][0] = 1;
            pascal[row][pascal[row].length - 1] = 1;
            for (int col = 1; col < pascal[row].length - 1; col++){
                pascal[row][col] = pascal[row-1][col-1] + pascal[row-1][col];
            }
        }

        for (long[] rows : pascal) {
            for (long col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
//Input could be integer - 3, 4 ,5 or whatever!!!





//Next commented rows could be used for adding of empty space
//Purpose: To print the result matrix as an triangle
//        for(int i = 0; i < countRows; i++){
//            System.out.println(String.join("", Collections.nCopies(intervalsCount, "*")));
//            intervalsCount--;
//        }
