import java.math.BigInteger;
import java.util.Scanner;

public class Ex04_ConvertFromBase10toBaseN_2Feb2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Integer base = Integer.parseInt(input[0]);
        String numberStr = input[1];
        BigInteger number = new BigInteger(numberStr);

        BigInteger remainder;

        StringBuilder result = new StringBuilder();

        if (base >= 2 && base <= 10) {
            while (!"0".equals(numberStr)) {
                remainder = number.mod(BigInteger.valueOf(base));

                number = number.divide(BigInteger.valueOf(base));
                numberStr = number.toString();

                result.append(remainder.toString());
            }
            System.out.println(result.reverse().toString());
        }
    }
}

/*
Input CRITICAL:
7 1254789363254125

Expected output CRITICAL:
525205353110232646


Input 1:
7 10

Expected output 1:
13


Input 2:
3 154

Expected output 2:
12201


Input 3:
5 123

Expected output 3:
443



Input 4:
4 1000

Expected output 4:
33220


Input 5:
9 3487

Expected output 5:
4704

*/