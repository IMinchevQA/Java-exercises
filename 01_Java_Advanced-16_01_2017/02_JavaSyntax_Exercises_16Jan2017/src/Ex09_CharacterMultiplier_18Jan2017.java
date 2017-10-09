import java.util.Scanner;
import java.util.Locale;

public class Ex09_CharacterMultiplier_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        String[] inputString = { input.next(), input.next() };
        input.close();

        int minLength = Math.min(inputString[0].length(), inputString[1].length());
        int maxLength = Math.max(inputString[0].length(), inputString[1].length());
        int sum = 0;


        for (int i = 0; i < minLength; i++) {
            sum += Integer.valueOf(inputString[0].charAt(i)) * Integer.valueOf(inputString[1].charAt(i));
        }

        if(inputString[0].length() != inputString[1].length()) {
            String longerStr = inputString[0].length() > inputString[1].length() ? inputString[0] : inputString[1];

            for (int i = minLength; i < maxLength; i++) {
                sum += Integer.valueOf(longerStr.charAt(i));
            }
        }
        System.out.println(sum);
    }
}