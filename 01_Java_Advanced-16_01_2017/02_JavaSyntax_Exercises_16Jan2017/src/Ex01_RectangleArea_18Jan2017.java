import java.util.Scanner;
import java.util.Locale;

public class Ex01_RectangleArea_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        double length = input.nextDouble();
        double width = input.nextDouble();

        System.out.printf("%.2f", calculateRectArea(length, width));


    }

    public static double calculateRectArea(double length, double width) {
        return length * width;
    }
}