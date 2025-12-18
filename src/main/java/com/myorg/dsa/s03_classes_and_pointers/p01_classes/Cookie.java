// Package declaration
package com.myorg.dsa.s03_classes_and_pointers.p01_classes;

/**
 * <h1>Cookie class defines the template for creating Cookies</h1>
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
   * Default constructor which initializes a Cookie object with default values to instance
   * variables.
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
