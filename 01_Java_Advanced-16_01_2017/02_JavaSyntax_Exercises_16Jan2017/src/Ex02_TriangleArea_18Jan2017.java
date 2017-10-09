import java.util.Scanner;
import java.util.Locale;


public class Ex02_TriangleArea_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner input = new Scanner(System.in);
        int[] pointA = { input.nextInt(), input.nextInt() };
        int[] pointB = { input.nextInt(), input.nextInt() };
        int[] pointC = { input.nextInt(), input.nextInt() };
        input.close();

        //result calculation formula acc. http://www.mathopenref.com/coordtrianglearea.html
        int result = Math.abs(((pointA[0] * (pointB[1] - pointC[1]))
                     + (pointB[0] * (pointC[1] - pointA[1]))
                     + (pointC[0] * (pointA[1] - pointB[1]))) / 2);

        System.out.println(result);
    }
}