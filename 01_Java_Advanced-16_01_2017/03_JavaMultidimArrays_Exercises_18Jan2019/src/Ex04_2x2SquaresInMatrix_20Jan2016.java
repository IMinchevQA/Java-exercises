import java.util.Locale;
import java.util.Scanner;

public class Ex04_2x2SquaresInMatrix_20Jan2016 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scan = new Scanner(System.in);

        String[] size = scan.nextLine().split("\\s");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];

        //Filling up matrix
        for (int rowFill = 0; rowFill < rows; rowFill++) {
            String[] currentRow = scan.nextLine().split("\\s");
            for (int colFill = 0; colFill < cols; colFill++) {
                matrix[rowFill][colFill] = currentRow[colFill];
            }
        }

        int squaresInMatrix = 0;

        //Seeking for squares
        for (int rowSeek = 0; rowSeek < rows - 1; rowSeek++) {
            for (int colSeek = 0; colSeek < cols - 1; colSeek++) {
                if(matrix[rowSeek][colSeek].equals(matrix[rowSeek][colSeek + 1])
                        && matrix[rowSeek][colSeek + 1].equals(matrix[rowSeek + 1][colSeek])
                        && matrix[rowSeek + 1][colSeek].equals(matrix[rowSeek + 1][colSeek + 1])){
                    squaresInMatrix++;
                }
            }
        }
        System.out.println(squaresInMatrix);
    }
}

// input - 3 4
//A B B D
//    E B B B
//    I J B B
