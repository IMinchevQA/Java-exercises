import java.util.Scanner;
import java.util.Locale;
import java.math.BigInteger;

public class Ex07_ProductOfNumbersN_M_18Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        int numberN = input.nextInt();
        int numberM = input.nextInt();

        int index = numberN;

        BigInteger product = BigInteger.valueOf(1);

        do{
            product = product.multiply(BigInteger.valueOf(index));
            index++;
        } while (index <= numberM);

        System.out.printf("product[%s..%s] = %s", numberN, numberM, product);
    }
}