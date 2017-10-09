import java.util.Scanner;
import java.util.Locale;

public class Ex07_OddEvenPairs_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        String lineNumbers = input.nextLine();
        String[] strNumbers = lineNumbers.split("\\s");

        int[] numbers = new int[strNumbers.length];

        if(strNumbers.length % 2 != 0){
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < strNumbers.length; i += 2) {
                numbers[i] = Integer.parseInt(strNumbers[i]);
                numbers[i+1] = Integer.parseInt(strNumbers[i + 1]);

                if(numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0){
                    System.out.printf("%d, %d -> both are even\n", numbers[i], numbers[i + 1]);
                } else if(numbers[i] % 2 != 0 && numbers[i + 1] % 2 != 0){
                    System.out.printf("%d, %d -> both are odd\n", numbers[i], numbers[i + 1]);
                } else {
                    System.out.printf("%d, %d -> different\n", numbers[i], numbers[i + 1]);
                }
            }
        }
    }
}