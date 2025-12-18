package com.myorg.dsa.s03_classes_and_pointers.p01_classes;

public class Main {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    Cookie cookieOne = new Cookie("green");
    Cookie cookieTwo = new Cookie("blue");

    cookieOne.setColor("yellow");

    System.out.println(cookieOne.getColor());
    System.out.println(cookieTwo.getColor());
  }
}
