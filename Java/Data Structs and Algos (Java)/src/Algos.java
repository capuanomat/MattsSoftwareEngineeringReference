import java.util.Comparator;

/**
 * Created by Matthieu J.B Capuano on 10/25/2017.
 * This is my personal reference of all the sorting algorithms I have learned (except maybe radix)
 * in Java.
 */
public class Algos {
    /* IN-PLACE ALGORITHMS: An in-place algorithm is one that does not copy the elements being sorted
                            into a new array/list/other structure during the sorting process. They are
                            "in-place" because the sorting takes place within the passed in structure.
                            An out of place sort would allocate a variable amount of space for external
                            storage.
       STABLE SORT:         If there are duplicate items in the list to be sorted, their order is not
                            mixed up when they are sorted. That is called being "stable".
       COMPARISON SORT:     All the sorting alogrithms below except radix sort are "comparison"
                            algorithms because they compare items within list.
     */

    /**
     * BUBBLE SORT: In-place. Stable.
     *              Best-case: O(n)
     *              Average-case: O(n^2)
     *              Worst-case: O(n^2)
     * @param arr           The array to be sorted
     * @param comparator    The comparator to use for individual comparisons of T
     * @param <T>           The type of object to be sorted in the array
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        if ((comparator == null) || arr == null) {
            throw new IllegalArgumentException("Passed in array or comparator is null.");
        }

        int len = arr.length;
        boolean swapped = true;
        int i = 0;
        while ((i < len) && (swapped)) {
            swapped = false;
            for (int j = 1; j < len - i; j++) {
                if (comparator.compare(arr[j], arr[j - 1]) < 0) {
                    swapped = true;
                    T temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            i++;
        }
    }

    /**
     * INSERTION SORT:  In-place. Stable.
     *                  Best-case: O(n)
     *                  Average-case: O(n^2)
     *                  Worst-case: O(n^2)
     * @param arr           The array to be sorted
     * @param comparator    The comparator to use for individual comparisons of T
     * @param <T>           The type of object to be sorted in the array
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if ((arr == null) || comparator == null) {
            throw new IllegalArgumentException("Passed in array or comparator is null.");
        }

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (comparator.compare(arr[j - 1], arr[j]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /**
     * SELECTION SORT:  In-place. NOT stable.
     *                  Best-case: O(n^2)
     *                  Average-case: O(n^2)
     *                  Worst-case: O(n^2)
     * @param arr           The array to be sorted
     * @param comparator    The comparator to use for individual comparisons of T
     * @param <T>           The type of object to be sorted in the array
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if ((arr == null) || comparator == null) {
            throw new IllegalArgumentException("Input array or comparator is null.");
        }

        int len = arr.length;
        boolean swapped = true;
        int i = 0;
        while (i < len) {   // Could replace with for loop
            swapped = false;
            int min  = i;
            for (int j = i + 1; j < len; j++) {
                if (comparator.compare(arr[j], arr[min]) < 0) {
                    swapped = true;
                    min = j;
                }
            }
            if (swapped == true) {
                T temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
            i++;
        }
    }

    // NOTE: The arrays above are iterative, Merge sort and Quick sort below are recursive.

    /**
     * MERGE SORT:  OUT-of-place. Stable.
     *              Best-case: O(nlogn)
     *              Average-case: O(nlogn)
     *              Worst-case: O(nlogn)
     * @param arr           The array to be sorted
     * @param comparator    The comparator to use for individual comparisons of T
     * @param <T>           The type of object to be sorted in the array
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if ((arr == null) || (comparator == null)) {
            throw new IllegalArgumentException("Input array or comparator is null.");
        }

        int len = arr.length;
        int middle = len / 2;
        if (len > 1) {
            T[] leftArray = (T[]) new Object[middle];
            T[] rightArray = (T[]) new Object[len - middle];
            for (int i = 0; i < leftArray.length; i++) {
                leftArray[i] = arr[i];
                rightArray[i] = arr[middle + i];
            }

            if (rightArray.length > leftArray.length) {
                rightArray[rightArray.length - 1] = arr[len - 1];
            }

            if (leftArray.length > 1) {
                mergeSort(leftArray, comparator);
            }
            if (rightArray.length > 1) {
                mergeSort(rightArray, comparator);
            }

            int mainIndex = 0;
            int leftIndex = 0;
            int rightIndex = 0;
            while ((leftIndex < leftArray.length) && (rightIndex < rightArray.length)) {
                if (comparator.compare(leftArray[leftIndex], rightArray[rightIndex]) < 0) {
                    arr[mainIndex++] = leftArray[leftIndex++];
                } else {
                    arr[mainIndex++] = rightArray[rightIndex++];
                }
            }

            while (leftIndex < leftArray.length) {
                arr[mainIndex++] = leftArray[leftIndex++];
            }

            while (rightIndex < rightArray.length) {
                arr[mainIndex++] = rightArray[rightIndex++];
            }
        }
    }
}
