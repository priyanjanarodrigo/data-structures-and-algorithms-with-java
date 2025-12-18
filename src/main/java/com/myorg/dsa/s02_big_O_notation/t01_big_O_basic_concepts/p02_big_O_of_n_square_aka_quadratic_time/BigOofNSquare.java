package com.myorg.dsa.s02_big_O_notation.t01_big_O_basic_concepts.p02_big_O_of_n_square_aka_quadratic_time;

/**
 * <h1>BigOofNSquare class demonstrates Big O : O(n^2)</h1>
 */
public class BigOofNSquare {

  /**
   * <h1>Prints the items up to the provided n value. Demonstrates O(n^2) time complexity</h1>
   * <p>
   * The nested for loops cause quadratic time growth: for each of the n iterations of the outer
   * loop, the inner loop executes n times. This results in n × n = n^2 total operations.
   * <p>
   * <pre>
   * Example:
   * - When n=3, the method performs 9 print operations (3 × 3).
   * - When n=10, it performs 100 operations (10 × 10).
   * </pre>
   *
   * @param n The number up to which the items are printed. Determines the iteration count for both
   *          outer and inner loops, directly impacting execution time.
   */
  public static void printItems(int n) {
    /* Variable to track the number of iterations (just for clarity) */
    int operation = 1;

    /* Outer loop: iterates n times */
    for (int i = 0; i < n; i++) {
      /* Inner loop: iterates n times for each outer loop iteration (n^2 total iterations) */
      for (int j = 0; j < n; j++) {
        /* Print operation executed n^2 times */
        System.out.println("Operation: " + (operation++) + " → i=" + i + ", j=" + j);
      }
    }
  }

  /**
   * <h2>Java main method</h2>
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    printItems(3);
  }
}
