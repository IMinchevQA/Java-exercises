import java.util.Scanner;

public class Ex01_ReadInput_17Jan2017 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word1 = input.next("\\w+");
        String word2 = input.next("\\w+");

        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        input.nextLine(); // Skip to the line end
        String word3 = input.nextLine();

        int sum = num1 + num2 + num3;

        System.out.print(word1 + " " + word2 + " " + word3 + " " + sum);
    }
}