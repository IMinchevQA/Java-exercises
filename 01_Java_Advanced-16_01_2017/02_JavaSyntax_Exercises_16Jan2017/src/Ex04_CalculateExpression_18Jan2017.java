import java.util.Scanner;
import java.util.Locale;

public class Ex04_CalculateExpression_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        double numA = input.nextDouble();
        double numB = input.nextDouble();
        double numC = input.nextDouble();
        double f1Result = Math.pow(((Math.pow(numA, 2) + Math.pow(numB, 2)) / (Math.pow(numA, 2) - Math.pow(numB, 2))), (numA + numB + numC) / Math.sqrt(numC));
        double f2Result = Math.pow((Math.pow(numA, 2) + Math.pow(numB, 2) - Math.pow(numC, 3)), (numA - numB));
        double diff = Math.abs(((numA + numB + numC) / 3) - ((f1Result + f2Result) / 2));


        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1Result, f2Result, diff);
    }
}