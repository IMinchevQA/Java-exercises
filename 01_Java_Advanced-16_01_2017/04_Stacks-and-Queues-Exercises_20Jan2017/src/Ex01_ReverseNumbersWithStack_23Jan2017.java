import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Scanner;

public class Ex01_ReverseNumbersWithStack_23Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        for (String number : input) {
            numbers.push(Integer.parseInt(number));
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}

//Input
//1 2 3 4 5