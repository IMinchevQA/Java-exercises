import java.util.Locale;
import java.util.Scanner;

public class Ex05_FromDecimalToBase7_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        String numBase7 = Integer.toString(num, 7);

        System.out.println(numBase7);

    }
}