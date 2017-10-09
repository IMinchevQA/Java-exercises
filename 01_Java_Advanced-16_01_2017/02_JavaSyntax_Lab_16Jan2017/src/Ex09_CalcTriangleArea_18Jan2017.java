import java.util.Scanner;
import java.util.Locale;

public class Ex09_CalcTriangleArea_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        double base = input.nextDouble();
        double height = input.nextDouble();

        double triangleArea = calculateTriangleArea(base, height);
        System.out.printf("Area = %.2f", triangleArea);

    }

    public static double calculateTriangleArea(double base, double height){

        return (base * height) / 2;
    }
}
