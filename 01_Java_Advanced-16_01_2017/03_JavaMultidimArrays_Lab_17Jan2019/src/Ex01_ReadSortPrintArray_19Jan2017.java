import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Ex01_ReadSortPrintArray_19Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        int length = Integer.parseInt(input.nextLine());
        String[] names = new String[length];

        for (int i = 0; i < names.length; i++) {
            names[i] = input.nextLine();
        }

        Arrays.sort(names);

        for (String name : names) {
            System.out.println(name);
        }
    }
}