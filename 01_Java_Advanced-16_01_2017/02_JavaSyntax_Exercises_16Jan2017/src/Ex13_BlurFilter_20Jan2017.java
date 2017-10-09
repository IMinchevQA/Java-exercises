import java.util.Locale;
import java.util.Scanner;

public class Ex13_BlurFilter_20Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        int blurAmount = Integer.parseInt(input.nextLine());

        String[] data = input.nextLine().split("\\s");

        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        long[][] matrix = new long[rows][cols];

        //Saving the input data in the matrix!!!
        for (int iRow = 0; iRow < rows; iRow++) {
            String[] currentRow = input.nextLine().split("\\s");
            for (int iCol = 0; iCol < cols; iCol++) {
                matrix[iRow][iCol] = Integer.parseInt(currentRow[iCol]);
            }
        }

        String[] pixelCoords = input.nextLine().split("\\s");

        int pixelX = Integer.parseInt(pixelCoords[0]);
        int pixelY = Integer.parseInt(pixelCoords[1]);

        int startRow = Math.max(0, pixelX - 1);
        int startCol = Math.max(0, pixelY - 1);
        int endRow = Math.min(rows, pixelX + 2);
        int endCol = Math.min(cols, pixelY + 2);

        //Blur amount add
        for (int rowBlur = startRow; rowBlur < endRow; rowBlur++) {
            for (int colBlur = startCol; colBlur < endCol; colBlur++) {
                matrix[rowBlur][colBlur] += blurAmount;
            }

        }

        //Print the result
        for (long[] printRow : matrix) {
            for (long element : printRow){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}


//Input
//9
//        3 3
//        1 1 1
//        1 1 1
//        1 1 1
//        1 1

//-------------------
//3
//        3 4
//        0 -5 4 20
//        0 20 4 -5
//        20 4 -5 0
//        1 2


