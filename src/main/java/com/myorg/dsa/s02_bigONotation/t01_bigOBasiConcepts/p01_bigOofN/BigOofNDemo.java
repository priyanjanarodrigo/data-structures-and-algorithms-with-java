package com.myorg.dsa.s02_bigONotation.t01_bigOBasiConcepts.p01_bigOofN;

/**
 * BigOofNDemo class demonstrates Big O : O(n).
 */
public class BigOofNDemo {

  /**
   * Example 1: Looping through an array:
   * -----------------------------------------------------------------------------------------------
   * Loops through the given int[] array and prints each item. Here we have a single for loop which
   * traverse through the array. Therefore, in this case we have n number of operations where n is
   * the length of the array. So the time complexity will be O(n).
   *
   * @param array The array which is traversed through
   */
  public static void traverseThroughArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

  /**
   * Example 2: Printing a desired number of items:
   * -----------------------------------------------------------------------------------------------
   * Prints the items up to the provided n value. Here we have a single for loop which runs n number
   * of times. Therefore, in this case we have n number of operations and the time complexity will
   * be O(n).
   *
   * @param n The number up to which the items are printed out. In other words, the value of n is
   *          used to determine the number of items to be printed.
   */
  public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(i);
    }
  }

  /**
   * Java main method.
   *
   * @param args String array arguments
   */
  public static void main(String[] args) {
    traverseThroughArray(new int[]{1, 2, 3, 4, 5});
    printItems(3);
  }
}
