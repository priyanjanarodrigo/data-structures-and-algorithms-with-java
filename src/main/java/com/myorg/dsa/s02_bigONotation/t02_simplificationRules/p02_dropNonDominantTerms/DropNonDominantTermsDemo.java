package com.myorg.dsa.s02_bigONotation.t02_simplificationRules.p02_dropNonDominantTerms;

public class DropNonDominantTermsDemo {

  /**
   * Prints the elements up to the provided n value. Here we have one set of nested for loops and a
   * regular for loop executed sequentially. The time complexity of nested for loops will be O(n x
   * n) times and the regular for loop will have the time complexity of O(n).
   *
   * @param n The number up to which the items are printed out. In other words, the value of n is
   *          used to determine the number of items to be printed.
   */
  public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println(i + " --- " + j);
      }
    }

    for (int r = 0; r < n; r++) {
      System.out.println(r);
    }
  }

  public static void main(String[] args) {
    printItems(3);
  }
}
