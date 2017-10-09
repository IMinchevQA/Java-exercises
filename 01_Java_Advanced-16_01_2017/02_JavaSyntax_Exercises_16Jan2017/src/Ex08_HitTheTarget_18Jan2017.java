import java.util.Scanner;
import java.util.Locale;

public class Ex08_HitTheTarget_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        for (int augend = 1; augend <= 20; augend++) {
            for (int addend = 1; addend <= 20; addend++) {
                if (augend + addend == num) {
                    System.out.printf("%d + %d = %d\n", augend, addend, num);
                }
            }
        }

        for (int minuend = 1; minuend <= 20; minuend++) {
            for (int subtrahend = 1; subtrahend <= 20; subtrahend++) {
                if (minuend - subtrahend == num) {
                    System.out.printf("%d - %d = %d\n", minuend, subtrahend, num);
                    break;
                }
            }
        }
    }
}