/**
 * Created by Ivan Minchev on 9/10/2017.
 */
public class BubbleSort {
    private static int[] sortedArr;

    public BubbleSort() {

    }

    public String bubbleSortForLoop(int[] arr) {
        sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        for (int i = 0; i < sortedArr.length; i++) {
            int temp = 0;
            for (int j = 1; j < sortedArr.length - i; j++){
                if (sortedArr[j-1] > sortedArr[j]) {
                    temp = sortedArr[j-1];
                    sortedArr[j-1] = sortedArr[j];
                    sortedArr[j] = temp;
                }
            }
        }
        return stringifySortedArr();
    }

    public String bubbleSortDoWhile(int[] arr) {
        sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        int temp;
        do {
            temp = 0;
            for (int i = 1; i < arr.length; i++) {
                if (sortedArr[i-1] > sortedArr[i]) {
                    temp = sortedArr[i-1];
                    sortedArr[i-1] = sortedArr[i];
                    sortedArr[i] = temp;
                }
            }
        } while(temp != 0);

        return stringifySortedArr();
    }

    private String stringifySortedArr() {
        StringBuilder sb = new StringBuilder();
        for (int number: this.sortedArr) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
