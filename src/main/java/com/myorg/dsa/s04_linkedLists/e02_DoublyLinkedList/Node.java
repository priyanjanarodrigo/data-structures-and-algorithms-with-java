package com.myorg.dsa.s04_linkedLists.e02_DoublyLinkedList;

/**
 * Node class: Structures a Node for a DoublyLinkedList.
 */
public class Node {

  public Node next; // Pointer to the next Node

  public Node prev; // Pointer to the previous Node

  public int value; //  Value of the Node

  /**
   * Parameterized which initializes a new Node with the specified value.
   *
   * @param value Value of the node to be assigned.
   */
  public Node(int value) {
    this.value = value;
  }

  /**
   * Overriding Object class toString() to provide a custom String representation for the Node
   * class, which is its value. Returns the String form of the value.
   *
   * @return String
   */
  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
