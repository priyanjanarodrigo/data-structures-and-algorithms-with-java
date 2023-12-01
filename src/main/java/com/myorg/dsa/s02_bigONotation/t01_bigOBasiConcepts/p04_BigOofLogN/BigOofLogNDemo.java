package com.myorg.dsa.s02_bigONotation.t01_bigOBasiConcepts.p04_BigOofLogN;

/**
 * BigOofLogNDemo class demonstrates Big O: O(log n)
 */
public class BigOofLogNDemo {

  /**
   * Performs binary search on the provided sorted array and returns the index where the specified
   * value is available. if the value is not available at any of the indexes, then -1 is returned.
   *
   * Binary search uses the divide and concur strategy on the provided sorted array. Therefore,
   * the time complexity will be O(log n)
   *
   * @param sortedArray Provided sorted array to search
   * @param value       The value which is searched to find out it's index
   * @return int
   */
  public static int binarySearch(int[] sortedArray, int value) {
    int low = 0;
    int high = sortedArray.length - 1;
    int mid;

    while (low <= high) {
      mid = (low + high) / 2;

      // If the value is found in the middle, return its index immediately
      if (sortedArray[mid] == value) {
        return mid;
      }

      // If the value is less than the middle item value, then ignore the left half
      if (sortedArray[mid] < value) {
        low = mid + 1;
      }

      // If the value is greater than the middle item value, then ignore the right half
      if (sortedArray[mid] > value) {
        high = mid - 1;
      }
    }

    // Returns -1 in case if the value is not present in any of the indexes
    return -1;
  }

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(binarySearch(sortedArray, 1));
    System.out.println(binarySearch(sortedArray, 4));
    System.out.println(binarySearch(sortedArray, 8));

    System.out.println(binarySearch(sortedArray, 10));
    System.out.println(binarySearch(sortedArray, -1));
    System.out.println(binarySearch(sortedArray, 23));
  }
}
