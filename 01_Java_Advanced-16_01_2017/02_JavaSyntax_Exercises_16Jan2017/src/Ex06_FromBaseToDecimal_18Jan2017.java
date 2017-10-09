import java.util.Locale;
import java.util.Scanner;

public class Ex06_FromBaseToDecimal_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        String num = input.nextLine();

        int numToBase10 = Integer.valueOf(num, 7);

        System.out.println(numToBase10);
    }
}