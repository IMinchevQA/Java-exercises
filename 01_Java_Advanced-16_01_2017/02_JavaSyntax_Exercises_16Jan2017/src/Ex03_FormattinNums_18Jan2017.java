import java.util.Scanner;
import java.util.Locale;

public class Ex03_FormattinNums_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        String aBinString = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');
//        Variant 2 to represent a as a BinaryString
//        String aBinString = Integer.toBinaryString(a);
        double b = input.nextDouble();
        double c = input.nextDouble();

//        Variant 2 to represent a as a BinaryString
//        while(aBinString.length() < 10){
//            aBinString = "0" + aBinString;
//        }

        System.out.printf("|%-10s|", Integer.toHexString(a).toUpperCase());
        System.out.printf("%s|", aBinString);
        System.out.printf("%10.2f|", b);
        System.out.printf("%-10.3f|", c);
    }
}