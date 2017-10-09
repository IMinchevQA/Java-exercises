import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubiksMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int moves = 0;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = i*cols + j+1;
            }
        }

        int N = Integer.parseInt(scanner.nextLine());
        int rounds;

        for (int i = 0; i < N; i++) {
            input = scanner.nextLine().split("\\s+");
            rounds = Integer.parseInt(input[2]);
            if (input[1].equals("up") || input[1].equals("down")) {
                int col = Integer.parseInt(input[0]);
                if (input[1].equals("up")) {
                    swapCol(matrix, col, -rounds);
                } else {
                    swapCol(matrix, col, rounds);
                }

            } else {
                int row = Integer.parseInt(input[0]);
                if (input[1].equals("left")) {
                    swapRow(matrix, row, -rounds);
                } else {
                    swapRow(matrix, row, rounds);
                }
            }
        }
        check(matrix);
    }
    private static void swapRow (int[][] matrix, int row, int turns ) {
        List<Integer> lineRow = new ArrayList<>();
        for (int i = 0; i < matrix[row].length; i++) {
            lineRow.add(matrix[row][i]);
        }
        turns %= matrix[0].length;
        if (turns < 0) {
            turns += matrix[0].length;
        }
        List<Integer> firstHalf = lineRow.subList(0,lineRow.size()- turns);
        List<Integer> secondHalf = lineRow.subList(lineRow.size() - turns, lineRow.size());
        secondHalf.addAll(firstHalf);
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = secondHalf.get(i);
        }
    }
    private static void swapCol (int[][] matrix, int col, int turns ) {
        List<Integer> lineRow = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            lineRow.add(matrix[i][col]);
        }
        turns %= matrix.length;
        if (turns < 0) {
            turns += matrix.length;
        }
        List<Integer> firstHalf = lineRow.subList(0,lineRow.size()-turns);
        List<Integer> secondHalf = lineRow.subList(lineRow.size() -turns, lineRow.size());
        secondHalf.addAll(firstHalf);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = secondHalf.get(i);
        }
    }
    private static void check(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = i*matrix[0].length + j+1;
                if (matrix[i][j] == value) {
                    System.out.println("No swap required");
                } else {
                    int[] coordinates = searchElement(matrix, value);
                    System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, coordinates[0], coordinates[1]);
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[coordinates[0]][coordinates[1]];
                    matrix[coordinates[0]][coordinates[1]] = temp;
                }
            }
        }
    }

    private static int[] searchElement(int[][] matrix, int value) {
        int[] coordinates = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == value) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    return coordinates;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
