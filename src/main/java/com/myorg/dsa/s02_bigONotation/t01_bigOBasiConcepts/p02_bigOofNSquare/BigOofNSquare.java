package com.myorg.dsa.s02_bigONotation.t01_bigOBasiConcepts.p02_bigOofNSquare;

/**
 * BigOofNSquare class demonstrates Big O : O(n^2).
 */
public class BigOofNSquare {

  /**
   * Prints the items up to the provided n value. Here we have nested for loops executed and the
   * time complexity will be O(n x n) = O(n^2) times.
   *
   * @param n The number up to which the items are printed out. In other words, the value of n is
   *          used to determine the number of items to be printed.
   */
  public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println(i + " -- " + j);
      }
    }
  }

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    printItems(3);
  }
}