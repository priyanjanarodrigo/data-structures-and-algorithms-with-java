package com.myorg.practise.algorithms.binary_search;

/**
 * <h1>BinarySearch class</h1>
 * <p>Implements binary search algorithm to find a key in a sorted array</p>
 */
public class BinarySearch {

  /**
   * <h2>Binary Search Algorithm</h2>
   * <hr>
   * <p>
   * Performs binary search to find whether the given key is present at some index of the provided
   * sorted array. If found, the index of the key will be returned; otherwise -1 is returned. If the
   * array is null or empty, an IllegalArgumentException is thrown.
   * </p>
   * <p>
   * <strong>Time Complexity:</strong> O(log n) where n is the number of elements in the array.
   * The execution time grows logarithmically with the array size.
   * </p>
   * <p>
   * <strong>Space Complexity:</strong> O(1) as the array is traversed in place with no extra
   * space.
   * </p>
   *
   * @param array the sorted array in which to search for the key; must not be null or empty.
   * @param key   the value to search for.
   * @return the index of the key, or -1 if not found.
   * @throws IllegalArgumentException if the array is null or empty.
   */
  public static int binarySearch(int[] array, int key) {
    if (array == null) {
      throw new IllegalArgumentException("array is required and cannot be null");
    }

    int low = 0;
    int high = array.length - 1;
    int mid;

    while (low <= high) {
      mid = low + (high - low) / 2;

      if (key == array[mid]) {
        return mid;
      } else if (key < array[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

  /**
   * <h2>Generic Binary Search Algorithm</h2>
   * <hr>
   * <p>
   * Performs binary search on a sorted array of Comparable objects to find the index of a specified
   * key. If found, the index of the key will be returned; otherwise -1 is returned. If the array is
   * null, an IllegalArgumentException is thrown.
   * </p>
   * <p>
   * <strong>Time Complexity:</strong> O(log n) where n is the number of elements in the array.
   * The execution time grows logarithmically with the array size.
   * </p>
   * <p>
   * <strong>Space Complexity:</strong> O(1) as the array is traversed in place with no extra
   * space.
   * </p>
   *
   * @param array the sorted array of Comparable objects in which to search for the key; must not be
   *              null.
   * @param key   the Comparable key to search for.
   * @param <T>   the type of elements in the array, which must implement Comparable<T>.
   * @return the index of the key, or -1 if not found.
   * @throws IllegalArgumentException if the array is null.
   */
  public static <T extends Comparable<T>> int binarySearchGeneric(T[] array, T key) {
    if (array == null) {
      throw new IllegalArgumentException("array is required and cannot be null");
    }

    if (key == null) {
      throw new IllegalArgumentException("key is required and cannot be null");
    }

    int low = 0;
    int high = array.length - 1;
    int mid;
    int comparisonResult;

    while (low <= high) {
      mid = low + (high - low) / 2;
      comparisonResult = key.compareTo(array[mid]);

      if (comparisonResult == 0) {
        return mid;
      } else if (comparisonResult < 0) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  /**
   * This private constructor prevents instantiation of the BinarySearch class. Since all methods in
   * this class are static, we don't need to create an instance. The private constructor enforces
   * this by making it impossible to do.
   */
  private BinarySearch() {
  }
}
