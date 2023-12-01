package com.myorg.dsa.s02_bigONotation;

public class DropConstantsDemo {

  /**
   * Prints the elements up to the provided n value. Here we have 2 for loops and both of them are
   * going to run n number of times one after the other. Therefore, in this case we have n + n
   * number of operations.
   *
   * @param n The number up to which the items are printed out. In other words, the value of n is
   *          used to determine the number of items to be printed.
   */
  public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(i);
    }

    for (int r = 0; r < n; r++) {
      System.out.println(r);
    }
  }

  public static void main(String[] args) {
    printItems(3);
  }
}
