import java.util.Locale;
import java.util.Scanner;
public class Ex03_FormattingNumbers_2Feb2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        String aBinString = Integer.toString(a, 2);
        while (aBinString.length() < 10) {
            aBinString = "0" + aBinString;
        }

        if (aBinString.length() > 10) {
            aBinString = aBinString.substring(0, 10);
        }
        double b = input.nextDouble();
        double c = input.nextDouble();

        System.out.printf("|%-10X|", a);
        System.out.printf("%s|", aBinString);
        System.out.printf("%10.2f|", b);
        System.out.printf("%-10.3f|", c);
    }
}

/*
Input 1:
254
11.6
0.5

Expected output 1:
|FE        |0011111110|     11.60|0.500     |


Input 2:
499
-0.5559
10000


Expected output 2:
|1F3       |0111110011|     -0.56|10000.000 |


Input 3:
0
3
-0.1234

Expected output 3:
|0         |0000000000|      3.00|-0.123    |


Input 4:
444
-7.5
7.5

Expected output 4:
|1BC       |0110111100|     -7.50|7.500     |

 */
