import java.util.Arrays;

/**
 * Created by Ivan Minchev on 9/26/2017.
 */
public class Ex07_ArraySorting {
    // https://visualgo.net/en/sorting
    public static void main(String[] args) {
        int[] arrayForSort = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48}; //arrayForSort();
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        int[] selectionSorted = Arrays.stream(arrayForSort).map(n -> n).toArray();
        startTime = System.nanoTime();
        selectionSort(selectionSorted);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / (double) 1000000);

        int[] bubbleSorted = Arrays.stream(arrayForSort).map(n -> n).toArray();
         startTime = System.nanoTime();
        bubbleSort(bubbleSorted);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / (double) 1000000);

        int[] insertionSorted = Arrays.stream(arrayForSort).map(n -> n).toArray();
        startTime = System.nanoTime();
        insertionSort(insertionSorted);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / (double) 1000000);

        startTime = System.nanoTime();
        int[] quickSorted = Arrays.stream(arrayForSort).map(n -> n).toArray();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / (double) 1000000);

        startTime = System.nanoTime();
        int[] mergeSorted = Arrays.stream(arrayForSort).map(n -> n).toArray();//{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        mergeSort(mergeSorted, 0, mergeSorted.length - 1);//Arrays.stream(arrayForSort).map(n -> n).toArray();
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / (double) 1000000);
    }

    
    private static void mergeSort(int[] input, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((end - start) / 2);
        mergeSort(input, start, mid);
        mergeSort(input, mid + 1, end);

        int left = start;
        int right = mid + 1;
        int result = 0;
        int[] temp = new int[end - start + 1];
        while (left <= mid && right <= end) {
            if (input[left] <= input[right]) {
                temp[result] = input[left];
                left++;
            } else {
                temp[result] = input[right];
                right++;
            }
            result++;
        }

        while (left <= mid) {
            temp[result] = input[left];
            result++;
            left++;
        }

        while (right <= end) {
            temp[result] = input[right];
            result++;
            right++;
        }

        System.arraycopy(temp, 0, input, start, temp.length);
    }

    private static void quickSort(int[] input, int low, int high) {
        if (low < high) {
            int pi = partition(input, low, high);

            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
    }

    private static int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (input[j] <= pivot) {
                i++;
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        int temp = input[i + 1];
        input[i + 1] = input[high]; // the pivot
        input[high] = temp;

        return i + 1;
    }

    private static void insertionSort(int[] input) {
        int valueToInsert;
        int holePosition;

        for (int i = 1; i < input.length; i++) {
            valueToInsert = input[i];
            holePosition = i;

            while (holePosition > 0
                    && input[holePosition - 1] > valueToInsert) {
                input[holePosition] = input[holePosition - 1];
                holePosition--;
            }
            input[holePosition] = valueToInsert;
        }
    }

    private static void selectionSort(int[] input) {
        int indexMinValue;

        for (int i = 0; i < input.length - 1; i++) {
            indexMinValue = i;
            for (int min = i + 1; min < input.length; min++) {
                if (input[min] < input[indexMinValue]) {
                    indexMinValue = min;
                }
            }

            if (indexMinValue != i) {
                int temp = input[i];
                input[i] = input[indexMinValue];
                input[indexMinValue] = temp;

            }
        }
    }

    private static void bubbleSort (int[] input) {
        boolean swapped;
        for (int i = 0; i < input.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    private static int[] arrayForSort() {
        int[] arrForSort = new int[10];
        for (int i = 0; i < arrForSort.length; i++) {
            arrForSort[arrForSort.length - 1 - i] = i + 1;
        }

        return arrForSort;
    }
}
