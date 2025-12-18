package com.myorg.dsa.s02_big_O_notation.t01_big_O_basic_concepts.p03_big_O_of_1;

/**
 * <h1>BigOof1Demo class demonstrates Big O: O(1) Constant time complexity.</h1>
 */
public class BigOof1Demo {

  /**
   * <h2>Example 3: Direct array access by index - O(1) Constant Time Complexity</h2>
   * <hr>
   * <p>
   * Retrieves and returns the value at a specified index within the provided int[] array.
   * Demonstrates constant time complexity O(1), the most efficient time complexity possible.
   * </p>
   * <p>
   * Regardless of the array size, this method always performs exactly one operation: direct index
   * access. Whether the array contains 10 elements or 10 million elements, the execution time
   * remains constant. This is because modern processors can access any array element in constant
   * time using direct memory addressing.
   * </p>
   * <pre>
   * Example:
   * - Array of 5 elements: 1 operation to access any element
   * - Array of 1,000 elements: 1 operation to access any element
   * - Array of 1,000,000 elements: 1 operation to access any element
   * </pre>
   * <p>
   * The execution time does NOT depend on the input size, making this the gold standard for
   * algorithm efficiency.
   * </p>
   *
   * @param array The array from which to retrieve the value. The size of this array has NO impact
   *              on execution time.
   * @param index The specific position in the array to access. Must be within valid bounds (0 to
   *              array.length - 1), otherwise a RuntimeException is thrown.
   * @return The integer value stored at the specified index
   * @throws RuntimeException if the index is negative or >= array.length
   */
  public static int getValueAt(int[] array, int index) {
    /* Bounds check: validates index is within valid range (two comparison operations) */
    if (index >= 0 && index < array.length) {
      /* Direct array access: executes in constant time O(1) regardless of array size */
      return array[index];
    }

    /* Error handling: throw exception for invalid index */
    throw new IndexOutOfBoundsException("Out of range index value provided");
  }

  /**
   * <h2>Java main method</h2>
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    int[] numbers = {23, 43, 56, 32, 23, 4546, 1232, 76, 234, 1, 0, 23, 66, 23, 43};
    System.out.println(getValueAt(numbers, 0));
    System.out.println(getValueAt(numbers, 3));
    System.out.println(getValueAt(numbers, 14));

    System.out.println(getValueAt(numbers, 22)); // Exception occurring scenario
  }
}
