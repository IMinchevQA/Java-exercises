import java.util.Locale;
import java.util.Scanner;

public class Ex02_SumMatrixElements_19Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        String[] length = input.nextLine().split(", ");
        int sum = 0;

        for (int row = 0; row < Integer.parseInt(length[0]); row++) {
            String[] currentRow = input.nextLine().split(", ");
            for (int col = 0; col < Integer.parseInt(length[1]); col++){
                sum += Integer.parseInt(currentRow[col]);
            }
        }

        for (String s : length) {
            System.out.println(Integer.parseInt(s));
        }

        System.out.println(sum);
    }
}
