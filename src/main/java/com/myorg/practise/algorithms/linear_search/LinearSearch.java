package com.myorg.practise.algorithms.linear_search;

/**
 * <h1>LinearSearch class</h1>
 * <p>Implements linear search algorithm to find a key in an array</p>
 */
public final class LinearSearch {

  /**
   * <h2>Linear Search Algorithm</h2>
   * <hr>
   * <p>
   * Performs linear search to find whether the given key is present at some index of the provided
   * array. If found, the index of the first occurrence will be returned; otherwise -1 is returned.
   * If the array is null, a NullPointerException is thrown.
   * </p>
   * <p>
   * <strong>Time Complexity:</strong> O(n) where n is the number of elements in the array.
   * The execution time is proportional to the array size.
   * </p>
   * <p>
   * <strong>Space Complexity:</strong> O(1) as the array is traversed in place with no extra
   * space.
   * </p>
   *
   * @param array the array in which to search for the key; must not be null.
   * @param key   the value to search for.
   * @return the index of the first occurrence of the key, or -1 if not found.
   * @throws NullPointerException if the array is null.
   */
  public static int performLinearSearch(int[] array, int key) {
    if (array == null) {
      throw new NullPointerException("The provided array is null");
    }

    int arrayLength = array.length;

    for (int i = 0; i < arrayLength; i++) {
      if (key == array[i]) {
        return i;
      }
    }

    return -1;
  }

  /**
   * This private prevents instantiation of the LinearSearch class. Since all methods in this class
   * are static, we don't need to create an instance. The private constructor enforces this by
   * making it impossible to do.
   */
  private LinearSearch() {
  }

  /**
   * <h2>Java main method</h2>
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    System.out.println(performLinearSearch(array, 3)); // Expected output: 2
    System.out.println(performLinearSearch(array, 7)); // Expected output: 6
    System.out.println(performLinearSearch(array, 10)); // Expected output: -1
  }
}
