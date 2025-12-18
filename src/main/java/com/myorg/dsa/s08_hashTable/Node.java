package com.myorg.dsa.s08_hashTable;

/**
 * Node class: Structures a Node which is applicable for a has table.
 */
public class Node {

  public String key; // Key property of the Node

  public int value; // Value property of the Node

  public Node next; // Pointer to the next Node SinglyLinkedList concept is used

  /**
   * Parameterized constructor which initializes a Node with key and value.
   *
   * @param key   Key property value.
   * @param value Value property value.
   */
  public Node(String key, int value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Provides a custom String representation to the Node.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "{ " + key + " , " + value + " }";
  }
}
