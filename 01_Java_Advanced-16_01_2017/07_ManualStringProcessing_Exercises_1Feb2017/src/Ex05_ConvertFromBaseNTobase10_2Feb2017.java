import java.math.BigInteger;
import java.util.Scanner;
public class Ex05_ConvertFromBaseNTobase10_2Feb2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Integer base = Integer.parseInt(input[0]);
        String numberStr = input[1];
        BigInteger number = new BigInteger(numberStr);
        int factor = 0;
        int currentPower = 0;


        BigInteger productsSum = BigInteger.valueOf(0);

        if (base >= 2 && base <= 10) {
            for (int i = 0; i < numberStr.length(); i++) {
                currentPower = numberStr.length() - 1 - i;
                factor = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
                productsSum = productsSum.add(BigInteger.valueOf(factor).multiply(BigInteger.valueOf(base).pow(currentPower)));
            }
            System.out.println(productsSum);
        }
    }
}


/*
Input CRITICAL:
7 525205353110232646

Expected output CRITICAL:
1254789363254125


Input 1:
7 13

Expected output 1:
10


Input 2:
3 12201

Expected output 2:
154


Input 3:
5 443

Expected output 3:
123



Input 4:
4 33220

Expected output 4:
1000


Input 5:
9 4704

Expected output 5:
3487
*/
