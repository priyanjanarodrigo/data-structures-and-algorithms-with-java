package com.myorg.dsa.s02_big_O_notation.t01_big_O_basic_concepts.p06_big_O_of_n_log_n;

import java.util.Arrays;

/**
 * <h1>BigOofNLogN class : Demonstrates Big O : O(n log n)</h1>
 * <hr>
 * <p>
 * Merge Sort is a divide-and-conquer algorithm that divides the array into halves, recursively
 * sorts them, and then merges the sorted halves back together. Time Complexity: O(n log n) in all
 * cases (best, average, worst) Space Complexity: O(n) for the temporary arrays used during merging
 */
public class BigOofNLogN {

  /**
   * Public method to initiate merge sort on the given array. Validates input and delegates to the
   * private recursive method.
   *
   * @param array the integer array to be sorted
   */
  public static void mergeSort(int[] array) {
    // Handle edge cases: null or empty arrays
    if (array == null || array.length == 0) {
      return;
    }

    // Start the recursive merge sort process with the entire array
    mergeSortHelper(array, 0, array.length - 1);
  }

  /**
   * Private recursive helper method that performs the divide-and-conquer sorting. Divides the array
   * into two halves until the base case is reached, then merges the sorted halves.
   *
   * @param array the array being sorted
   * @param left  the starting index of the current subarray
   * @param right the ending index of the current subarray
   */
  private static void mergeSortHelper(int[] array, int left, int right) {
    // Base case: if left < right, the subarray has more than one element
    if (left < right) {
      // Calculate the middle index to avoid integer overflow
      int mid = left + (right - left) / 2;

      // Recursively sort the left half
      mergeSortHelper(array, left, mid);

      // Recursively sort the right half
      mergeSortHelper(array, mid + 1, right);

      // Merge the two sorted halves
      merge(array, left, mid, right);
    }
  }

  /**
   * <p>
   * Merges two sorted subarrays into a single sorted subarray. This is the key operation that
   * achieves O(n log n) complexity.
   * </p>
   *
   * <h5>Explanation:</h5>
   * <p>
   * The merge function combines two sorted halves of the array into a single sorted segment. It
   * first creates temporary arrays to hold the left and right halves. Then, it uses three pointers
   * to track the current index in the left array, right array, and the main array. By comparing the
   * elements pointed to by the left and right pointers, it places the smaller element into the main
   * array and advances the corresponding pointer. This process continues until all elements from
   * both temporary arrays have been merged back into the main array in sorted order.
   * </p>
   *
   * <h5>Time Complexity:</h5>
   * <p>
   * The merge operation runs in linear time O(n), where n is the total number of elements being
   * merged. This is because each element from both subarrays is processed exactly once. The overall
   * time complexity of the merge sort algorithm is O(n log n) because the array is repeatedly
   * divided in half (log n divisions), and each division requires a linear time merge operation.
   * </p>
   *
   * <h5> Space Complexity: </h5>
   * <p>
   * The merge function uses additional space for the temporary arrays that hold the left and right
   * halves. This results in a space complexity of O(n) for the merge sort algorithm, as it requires
   * extra storage proportional to the size of the input array.
   * </p>
   *
   * @param array the array containing both subarrays
   * @param left  the starting index of the left subarray
   * @param mid   the ending index of the left subarray (and mid-point)
   * @param right the ending index of the right subarray
   */
  private static void merge(int[] array, int left, int mid, int right) {
    // Calculate sizes of the two subarrays to be merged
    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    // Create temporary arrays to hold the two halves
    int[] leftArray = new int[leftSize];
    int[] rightArray = new int[rightSize];

    // Copy data to temporary left array
    for (int i = 0; i < leftSize; i++) {
      leftArray[i] = array[left + i];
    }

    // Copy data to temporary right array
    for (int i = 0; i < rightSize; i++) {
      rightArray[i] = array[mid + 1 + i];
    }

    // Merge the temporary arrays back into the original array
    // Initialize pointers for left, right, and main array
    int i = 0;      // pointer for leftArray
    int j = 0;      // pointer for rightArray
    int k = left;   // pointer for the main array

    // Compare elements from both temporary arrays and place the smaller one
    while (i < leftSize && j < rightSize) {
      if (leftArray[i] <= rightArray[j]) {
        array[k++] = leftArray[i++];
      } else {
        array[k++] = rightArray[j++];
      }
    }

    // Copy remaining elements from the left array (if any)
    while (i < leftSize) {
      array[k++] = leftArray[i++];
    }

    // Copy remaining elements from the right array (if any)
    while (j < rightSize) {
      array[k++] = rightArray[j++];
    }
  }

  /**
   * Helper method to print array elements.
   *
   * @param array the array to be printed
   */
  private static void printArray(int[] array) {
    System.out.println(Arrays.toString(array));
  }

  /**
   * <h2>Java main method</h2>
   * Demonstrates the merge sort algorithm with sample data.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {

    // Test case 1: Unsorted array
    int[] array1 = {38, 27, 43, 3, 9, 82, 10};
    System.out.println("Original array: ");
    printArray(array1);

    mergeSort(array1);
    System.out.println("Sorted array: ");
    printArray(array1);

    System.out.println();

    // Test case 2: Array with duplicates
    int[] array2 = {5, 2, 8, 2, 9, 1, 5};
    System.out.println("Original array with duplicates: ");
    printArray(array2);

    mergeSort(array2);
    System.out.println("Sorted array: ");
    printArray(array2);
  }
}

