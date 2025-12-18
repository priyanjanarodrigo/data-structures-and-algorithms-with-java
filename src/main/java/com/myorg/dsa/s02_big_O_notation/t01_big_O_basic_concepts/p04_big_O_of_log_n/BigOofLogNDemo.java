package com.myorg.dsa.s02_big_O_notation.t01_big_O_basic_concepts.p04_big_O_of_log_n;

import java.util.Arrays;

/**
 * BigOofLogNDemo class demonstrates Big O: O(log n)
 */
public class BigOofLogNDemo {

  /**
   * <h2>Binary Search Algorithm - O(log n) Logarithmic Time Complexity</h2>
   * <hr>
   * <p>
   * Performs binary search on a sorted array to find the index of a specified value. Demonstrates
   * logarithmic time complexity O(log n), which is highly efficient for large datasets.
   * </p>
   * <p>
   * Binary search uses the "divide and conquer" strategy by repeatedly halving the search space.
   * With each comparison, the algorithm eliminates half of the remaining elements, resulting in
   * logarithmic growth. This is exponentially faster than linear search O(n) for large arrays.
   * </p>
   * <pre>
   * Example:
   * - Array of 8 elements: maximum 3 comparisons needed (log₂ 8 = 3)
   * - Array of 1,024 elements: maximum 10 comparisons needed (log₂ 1,024 = 10)
   * - Array of 1,000,000 elements: maximum 20 comparisons needed (log₂ 1,000,000 ≈ 20)
   * </pre>
   *
   * <p>
   * <b>IMPORTANT !! </b><br>The input array MUST be sorted in ascending order for this algorithm
   * to work correctly. Unsorted arrays will produce incorrect results.
   * </p>
   *
   * @param sortedArray The input array to search. MUST be sorted in ascending order. The size of
   *                    this array directly affects the logarithm of execution time, not linearly.
   * @param value       The target value to locate within the sorted array
   * @return The zero-based index of the target value if found, or -1 if the value is not present in
   * the array
   */
  public static int binarySearch(int[] sortedArray, int value) {

    /* Input validation: ensure the array is not null */
    if (sortedArray == null) {
      throw new IllegalArgumentException("sortedArray is required and cannot be null");
    }

    /* Initialize search boundaries: low marks the start, high marks the end of search space */
    int low = 0;
    int high = sortedArray.length - 1;
    int mid;

    /* Continue searching while the search space is valid (low <= high).
       Each iteration reduces the search space by half (divide and conquer) */
    while (low <= high) {
      /* Calculate middle index: using (low + high) / 2
         Note: (low + high) / 2; can cause integer overflow with very large indices.
         Therefore, (low + (high - low) / 2) is safer to use */
      mid = low + (high - low) / 2;

      /* Best case scenario: target found at middle position - O(1) - return immediately */
      if (sortedArray[mid] == value) {
        return mid;
      }

      /* Target is in the right half: eliminate left half by moving low boundary
         Reduces search space from n to n/2 */
      if (sortedArray[mid] < value) {
        low = mid + 1;
      }

      /* Target is in the left half: eliminate right half by moving high boundary
         Reduces search space from n to n/2 */
      if (sortedArray[mid] > value) {
        high = mid - 1;
      }
    }

    /* Value not found: search space has been exhausted (low > high means no elements remain) */
    return -1;
  }


  /**
   * <h2>Generic Binary Search Algorithm - O(log n) Logarithmic Time Complexity</h2>
   * <hr>
   * <p>
   * Performs binary search on a sorted array of Comparable objects to find the index of a specified
   * key. Demonstrates logarithmic time complexity O(log n), which is highly efficient for large
   * datasets.
   * </p>
   * <p>
   * Binary search uses the "divide and conquer" strategy by repeatedly halving the search space.
   * With each comparison, the algorithm eliminates half of the remaining elements, resulting in
   * logarithmic growth. This is exponentially faster than linear search O(n) for large arrays.
   * </p>
   * <pre>
   * Example:
   * - Array of 8 elements: maximum 3 comparisons needed (log₂ 8 = 3)
   * - Array of 1,024 elements: maximum 10 comparisons needed (log₂ 1,024 = 10)
   * - Array of 1,000,000 elements: maximum 20 comparisons needed (log₂ 1,000,000 ≈ 20)
   * </pre>
   *
   * @param sortedArray The input array of Comparable objects to search. MUST be sorted in ascending
   *                    order. The size of this array directly affects the logarithm of execution
   *                    time, not linearly.
   * @param key         The target Comparable object to locate within the sorted array
   * @param <T>         The type parameter extending Comparable to ensure objects can be compared
   * @return The zero-based index of the target key if found, or -1 if the key is not present in the
   * array
   */
  public static <T extends Comparable<T>> int executeGenericBinarySearch(T[] sortedArray, T key) {
    /* Input validation: ensure the array is not null to prevent NullPointerException */
    if (sortedArray == null) {
      throw new IllegalArgumentException("sortedArray is required and cannot be null");
    }

    /* Input validation: ensure the key is not null to prevent NullPointerException
       during compareTo() invocation */
    if (key == null) {
      throw new IllegalArgumentException("key is required and cannot be null");
    }

    /* Initialize search boundaries: low marks the start, high marks the end of search space */
    int low = 0;
    int high = sortedArray.length - 1;
    int mid;
    int comparison;

    /* Continue searching while the search space is valid (low <= high).
       Each iteration reduces the search space by half (divide and conquer) */
    while (low <= high) {
    /* Calculate middle index using safer formula to prevent integer overflow with very large indices.
       Formula: low + (high - low) / 2 avoids the potential overflow of (low + high) / 2 */
      mid = low + (high - low) / 2;

      /* Compare the key with the middle element using the Comparable interface.
         compareTo() returns: 0 if equal, negative if key < mid-element, positive if key > mid-element */
      comparison = key.compareTo(sortedArray[mid]);

      /* Best case scenario: target found at middle position - O(1) - return immediately */
      if (comparison == 0) {
        return mid;
      }

      /* Target is in the left half: eliminate right half by moving high boundary.
         Reduces search space from n to n/2 */
      else if (comparison < 0) {
        high = mid - 1;
      }

      /* Target is in the right half: eliminate left half by moving low boundary.
         Reduces search space from n to n/2 */
      else {
        low = mid + 1;
      }
    }

    /* Value not found: search space has been exhausted (low > high means no elements remain) */
    return -1;
  }

  /**
   * <h2>Test Binary Search Method</h2>
   */
  public static void testBinarySearch() {
    System.out.println("--- Binary Search Tests ---");
    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println("sortedArray : " + Arrays.toString(sortedArray));
    System.out.println("key = " + 1 + " -> " + binarySearch(sortedArray, 1)); // Expected output: 0
    System.out.println("key = " + 4 + " -> " + binarySearch(sortedArray, 4));// Expected output: 3
    System.out.println("key = " + 8 + " -> " + binarySearch(sortedArray, 8)); // Expected output: 7

    // Testing value not present scenarios. Expected output: -1
    System.out.println("key = " + 10 + " -> " + binarySearch(sortedArray, 10));
    System.out.println("key = " + -1 + " -> " + binarySearch(sortedArray, -1));
    System.out.println("key = " + 23 + " -> " + binarySearch(sortedArray, 23));
  }

  /**
   * <h2>Test Generic Binary Search Method</h2>
   */
  public static void testGenericBinarySearch() {
    System.out.println("--- Generic Binary Search Tests ---");
    String[] sortedArray = {"Apple", "Banana", "Cherry", "Date", "Fig", "Grape"};
    System.out.println("sortedArray : " + Arrays.toString(sortedArray));

    System.out.println("key = " + "Apple -> " + executeGenericBinarySearch(sortedArray,
        "Apple")); // Expected output: 0
    System.out.println("key = " + "Date -> " + executeGenericBinarySearch(sortedArray,
        "Date"));   // Expected output: 3
    System.out.println("key = " + "Grape -> " +
        executeGenericBinarySearch(sortedArray, "Grape"));  // Expected output: 5

    // Testing value not present scenarios. Expected output: -1
    System.out.println("key = " + "Mango -> " + executeGenericBinarySearch(sortedArray, "Mango"));
    System.out.println("key = " + "Orange -> " + executeGenericBinarySearch(sortedArray, "Orange"));
    System.out.println("key = " + "Pineapple -> " +
        executeGenericBinarySearch(sortedArray, "Pineapple"));
  }

  /**
   * <h2>Java main method</h2>
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    testBinarySearch();
    System.out.println();
    testGenericBinarySearch();
  }
}
