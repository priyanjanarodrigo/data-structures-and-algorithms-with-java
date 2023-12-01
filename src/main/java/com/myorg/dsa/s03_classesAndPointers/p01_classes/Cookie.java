// Package declaration
package com.myorg.dsa.s03_classesAndPointers.p01_classes;

/**
 * Cookie class defines the template for creating Cookies.
 */
public class Cookie {

  // Instance variable color
  private String color;

  /**
   * Getter method which indirectly returns the color.
   *
   * @return String
   */
  public String getColor() {
    return this.color;
  }

  /**
   * Setter method which sets the specified value indirectly to color.
   *
   * @param color Color value to set
   */
  public void setColor(String color) {
    this.color = color;
  }


  /**
   * Default constructor which initializes Cookie object with default values to instance variables.
   */
  public Cookie() {
  }

  /**
   * Parameterized constructor for initializing Cookie object values.
   *
   * @param color Color of the Cookie.
   */
  public Cookie(String color) {
    this.color = color;
  }
}
