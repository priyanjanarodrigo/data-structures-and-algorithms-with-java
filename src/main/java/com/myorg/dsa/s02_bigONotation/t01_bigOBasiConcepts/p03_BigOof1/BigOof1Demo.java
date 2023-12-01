package com.myorg.dsa.s02_bigONotation.t01_bigOBasiConcepts.p03_BigOof1;

/**
 * BigOof1Demo class demonstrates Big O : O(1) constant time complexity.
 */
public class BigOof1Demo {

  /**
   * Returns the value of the specified index within the give int[] array. If the index is out of
   * bounds an exception will be thrown.
   *
   * Here, regardless of the size of the array (size of the data set), only one operation will be
   * performed as the given index is directly accessed and then the value is returned immediately.
   *
   * Therefore, this particular code is executed in constant time which can be represented as O(1).
   * This is the most efficient time complexity an algorithm/ piece of code can have.
   *
   * @param array Array to be searched
   * @param index Specified index to search for it's value
   * @return int
   */
  public static int getValueAt(int[] array, int index) {
    if (index >= 0 && index < array.length) {
      return array[index];
    }

    throw new RuntimeException("Out of range index value provided");
  }

  /**
   * Java main method.
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
