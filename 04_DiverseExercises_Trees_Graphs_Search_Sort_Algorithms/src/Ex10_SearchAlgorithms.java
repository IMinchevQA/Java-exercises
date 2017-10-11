import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ivan Minchev on 9/29/2017.
 */
public class Ex10_SearchAlgorithms {
    public static void main(String[] args) {
        int[] randomNums = randomArray();
//        mergeSort(randomNums, 0, randomNums.length - 1);
//        randomNums = removeDuplicates(randomNums);
        int[] sortedArray = sortedArray();
        int[] shuffledArray = (shuffle(sortedArray));
        int[] interpolationSearchArr = {1000, 1100, 1200, 1300, 1350, 1400, 1500, 1600, 1700, 1800, 1900, 2000};
        int interpolationSearchedElement = 1350;

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        int searchedElement = 285325;

        startTime = System.nanoTime();
        int indexLinearSearch = linearSEarch(shuffledArray, searchedElement);
        endTime = System.nanoTime();
        System.out.println(indexLinearSearch);
        System.out.println((endTime - startTime) / (double) 1000000);

        startTime = System.nanoTime();
        int indexBinarySearch = binarySearch(shuffledArray, searchedElement, 0, randomNums.length);
        endTime = System.nanoTime();
        System.out.println(indexBinarySearch);
        System.out.println((endTime - startTime) / (double) 1000000);

        startTime = System.nanoTime();
        int indexInterpolationSearch = interpolationSearch(shuffledArray, searchedElement);//interpolationSearch(interpolationSearchArr, interpolationSearchedElement);
        endTime = System.nanoTime();
        System.out.println(indexInterpolationSearch);
        System.out.println((endTime - startTime) / (double) 1000000);

    }


    public static int[] shuffle(int[] array) {
        int[] result = Arrays.stream(array).map(n -> n).toArray();
        int n = result.length - 1;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomValue = i + random.nextInt(n - i);
            int randomElement = array[randomValue];
            array[randomValue] = array[i];
            array[i] = array[randomElement];
        }
        return result;
    }



    private static int interpolationSearch(int[] sortedArray, int searchedElement) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (sortedArray[low] <= searchedElement && sortedArray[high] >= searchedElement) {
            int mid = low + ((searchedElement - sortedArray[low])
                    / (sortedArray[high] - sortedArray[low])
                    * (high - low));

            if (searchedElement < sortedArray[mid]) {
                high = mid - 1;
            } else if (searchedElement > sortedArray[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        if (sortedArray[low] == searchedElement) {
            return low;
        }

        return -1;
    }

    private static int binarySearch(int[] sortedArray, int searchedElement, int start, int end) {
        int indexFound = - 1;
        if (end < start) {
            return indexFound;
        } else {
            int mid = (start + end) / 2;
            if (sortedArray[mid] > searchedElement) {
                return binarySearch(sortedArray, searchedElement, start, mid - 1);
            } else if (sortedArray[mid] < searchedElement) {
                return binarySearch(sortedArray, searchedElement, mid + 1, end);
            } else {
                return mid;
            }
        }
    }

    private static int linearSEarch(int[] randomNums, int searchedElement) {
        int indexFound = -1;
        for (int i = 0; i < randomNums.length; i++) {
            if (randomNums[i] == searchedElement) {
                indexFound = i;
                break;
            }
        }


        return indexFound;
    }

    private static int[] removeDuplicates(int[] arr) {
        int count = 0;
        int l = arr.length;
        int[] tempArr = new int[l];
        for (int i = 0; i < l; i++) {
            tempArr[count] = arr[i];
            count++;
            while (i < (l - 1) && arr[i + 1] == arr[i]) {
                i++;
            }
        }

        int[] resultArr = new int[count];
        System.arraycopy(tempArr, 0, resultArr, 0, count);
        return resultArr;
    }


    private static int[] randomArray() {
        int[] randomArray = new int[500000];
        Random rand = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(500000);
        }
        return randomArray;
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
        int indexResult = 0;
        int[] result = new int[end - start + 1];

        while (left <= mid && right <= end) {
            if (input[left] <= input[right]) {
                result[indexResult] = input[left];
                left++;
            } else {
                result[indexResult] = input[right];
                right++;
            }
            indexResult++;
        }

        while (left <= mid) {
            result[indexResult] = input[left];
            left++;
            indexResult++;

        }

        while (right <= end) {
            result[indexResult] = input[right];
            right++;
            indexResult++;
        }

        System.arraycopy(result, 0, input, start, result.length);
    }

    private static int[] sortedArray() {
        int[] arrForSort = new int[5000000];
        for (int i = 0; i < arrForSort.length; i++) {
            arrForSort[i] = i + 1;
        }

        return arrForSort;
    }

}
