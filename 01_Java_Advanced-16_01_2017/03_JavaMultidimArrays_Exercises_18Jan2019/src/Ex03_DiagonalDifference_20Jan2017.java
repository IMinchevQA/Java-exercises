import java.util.Locale;
import java.util.Scanner;

public class Ex03_DiagonalDifference_20Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        Scanner scan = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[sizeMatrix][sizeMatrix];

        int sumMainDiag = 0;
        int sumSecDiag = 0;

        //Filling up the matrix
        for (int iRowFill = 0; iRowFill < sizeMatrix; iRowFill++) {
            String[] currentRow = scan.nextLine().split("\\s");
            for (int iColFill = 0; iColFill < sizeMatrix; iColFill++) {
                matrix[iRowFill][iColFill] = Integer.parseInt(currentRow[iColFill]);
            }
        }

        //Diagonals values summation
        for (int iRowSum = 0; iRowSum < sizeMatrix; iRowSum++) {
            for (int iColSum = 0; iColSum < sizeMatrix; iColSum++) {
                if (iRowSum == iColSum) {
                    sumMainDiag += matrix[iRowSum][iColSum];
                }

                if (iRowSum + iColSum + 1 == sizeMatrix) {
                    sumSecDiag += matrix[iRowSum][iColSum];
                }
            }
        }

        System.out.println(Math.abs(sumMainDiag - sumSecDiag));
    }
}

//Input
//3
//        11 2 4
//        4 5 6
//        10 8 -12



