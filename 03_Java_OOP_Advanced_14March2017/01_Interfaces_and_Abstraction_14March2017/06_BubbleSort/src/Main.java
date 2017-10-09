import java.util.Arrays;

/**
 * Created by Ivan Minchev on 9/10/2017.
 */
public class Main {
    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();
        int[] arrForLoop = {5, 4, 3, 2, 1};
        int[] arrDoWhile = {14, 15, 11, 13, 12};

        System.out.printf("%s -> Sorted with for-loop numbers: %s", stringifyInputArr(arrForLoop), bs.bubbleSortForLoop(arrForLoop));
        System.out.println();
        System.out.printf("%s -> Sorted with Do-While numbers: %s", stringifyInputArr(arrDoWhile), bs.bubbleSortDoWhile(arrDoWhile));
    }

    private static String stringifyInputArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int number: arr) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
