import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] main){
        Locale.setDefault(Locale.ROOT);
        String someString ="" + 'a' + 'b' + 'c';
        String someStringAddOne = "" + (char)('a' + 1) + (char)('b' + 1) + (char)('c' + 1);

        System.out.printf("someString = %1$s\nsomeStringAddOne = %2$s", someString, someStringAddOne);

    }
}
