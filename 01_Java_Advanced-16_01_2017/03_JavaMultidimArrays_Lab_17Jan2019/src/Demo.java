import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] jaggedArr = new int[3][];

        //Read the input matrix!!!
        for (int rowRead = 0; rowRead < 3; rowRead++) {
            String[] currentRow = input.nextLine().split(", ");
            jaggedArr[rowRead] = new int[currentRow.length];
            for (int colRead = 0; colRead < currentRow.length; colRead++) {
                jaggedArr[rowRead][colRead] = Integer.parseInt(currentRow[colRead]);
            }
        }

        for (int[] row : jaggedArr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

//Reading and printing of jagged matrix - input 1, 2, Enter 3, 4 ,5 Enter 6, 7, 8, 9
//        Scanner input = new Scanner(System.in);
//        int[][] jaggedArr = new int[3][];
//
//        //Read the input matrix!!!
//        for (int rowRead = 0; rowRead < 3; rowRead++) {
//            String[] currentRow = input.nextLine().split(", ");
//            jaggedArr[rowRead] = new int[currentRow.length];
//            for (int colRead = 0; colRead < currentRow.length; colRead++) {
//                jaggedArr[rowRead][colRead] = Integer.parseInt(currentRow[colRead]);
//            }
//        }
//
//        for (int[] row : jaggedArr) {
//            for (int col : row) {
//                System.out.print(col + " ");
//            }
//            System.out.println();
//        }


//Reading input matrix - input: 2 + enter press + 2
//        Scanner scanner = new Scanner(System.in);
//        int rows = Integer.parseInt(scanner.nextLine());
//        int cols = Integer.parseInt(scanner.nextLine());
//        int[][] matrix = new int[rows][cols];
//        for (int row = 0; row < rows; row++) {
//            for (int column = 0; column < cols; column++) {
//                System.out.print(
//                        String.format("matrix[%1$d][%2$d] = ", row, column));
//                String inputNumber = scanner.nextLine();
//                matrix[row][column] = Integer.parseInt(inputNumber);
//            }
//        }
//    }

//------------------------------------------------------------
//        Scanner scanner = new Scanner(System.in);
//        int rows = Integer.parseInt(scanner.nextLine());
//        int cols = Integer.parseInt(scanner.nextLine());
//        int[][] matrix = new int[rows][cols];
//        for (int row = 0; row < rows; row++) {
//            for (int column = 0; column < cols; column++) {
//                System.out.print(
//                        String.format("matrix[%1$d][%2$d] = ", row, column));
//                String inputNumber = scanner.nextLine();
//                matrix[row][column] = Integer.parseInt(inputNumber);
//            }
//        }



//No input
//    public static void main(String[] args) {
//        Locale.setDefault(Locale.ROOT);
//        String[] names = { "Peter", "Maria", "Katia", "Todor" };
//        for (int i = 0; i < names.length; i++) {
//            System.out.printf("names [%d] = %s\n", i, names[i]);
//        }
//
//        for(String name : names){
//            System.out.println(name);
//        }
//
////        names[4] = "Izdislav"; //ArrayIndexOutOfBoundsException
//
//
//    }

