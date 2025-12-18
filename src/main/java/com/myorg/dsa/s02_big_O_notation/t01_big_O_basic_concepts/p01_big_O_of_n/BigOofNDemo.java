package com.myorg.dsa.s02_big_O_notation.t01_big_O_basic_concepts.p01_big_O_of_n;

/**
 * <h1>BigOofNDemo class : Demonstrates Big O : O(n)</h1>
 */
public class BigOofNDemo {

  /**
   * <h1>Example 1: Looping through an array - O(n) Time Complexity</h1>
   * <hr>
   * <p>
   * Traverses and prints each element in the provided int[] array. Demonstrates linear time
   * complexity O(n) where n is the length of the array.
   * </p>
   * <p>
   * The single for loop executes exactly once for each array element. This results in a linear
   * relationship between input size and execution time: doubling the array size doubles the
   * operations required.
   * </p>
   * <pre>
   * Example:
   * - Array of 5 elements: 5 print operations
   * - Array of 100 elements: 100 print operations
   * - Array of 1,000 elements: 1,000 print operations
   * </pre>
   *
   * @param array The array to be traversed and printed. The array length directly determines the
   *              number of iterations and thus the execution time.
   */
  public static void traverseThroughArray(int[] array) {
    /* Single loop: iterates exactly array.length times (linear complexity) */
    for (int i = 0; i < array.length; i++) {
      /* Print operation executed n times, where n = array.length */
      System.out.println("array[" + i + "] = " + array[i]);
    }
  }

  /**
   * <h2>Example 2: Printing the desired number of items - O(n) Time Complexity</h2>
   * <hr>
   * <p>
   * Prints integers from 0 to n-1. Demonstrates linear time complexity O(n) where n is the input
   * parameter.
   * </p>
   * <p>
   * The single for loop executes exactly n times, creating a linear relationship between input size
   * and execution time. This means if you double n, you double the number of operations required.
   * </p>
   * <pre>
   * Example:
   * - n = 5: prints 5 items (0, 1, 2, 3, 4)
   * - n = 100: prints 100 items
   * - n = 1,000: prints 1,000 items
   * </pre>
   *
   * @param n The upper limit (exclusive) for printing items. Directly determines the iteration
   *          count and thus the execution time. Each unit increase in n adds one more operation.
   */
  public static void printItems(int n) {
    // Single loop: executes exactly n times (linear complexity)
    for (int i = 0; i < n; i++) {
      // Print operation executed n times, where n is the input parameter
      System.out.println(i);
    }
  }

  /**
   * <h2>Java main method.</h2>
   * <hr>
   *
   * @param args String array arguments
   */
  public static void main(String[] args) {
    traverseThroughArray(new int[]{1, 2, 3, 4, 5});
    System.out.println();
    printItems(3);
  }
}
