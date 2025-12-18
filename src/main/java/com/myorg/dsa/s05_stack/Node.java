package com.myorg.dsa.s05_stack;

/**
 * Node class : Node class which is used when constructing a singly linked list is utilized here
 * also as we are using a singly linked list for implementing stack.
 */
public class Node {

  public int value; // Value of the Node

  public Node next; // Pointer to the next Node

  public Node(int value) {
    this.value = value;
  }

  /**
   * Overriding Object class toString in order to provide a custom String representation for the
   * Node class.
   *
   * @return String
   */
  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
