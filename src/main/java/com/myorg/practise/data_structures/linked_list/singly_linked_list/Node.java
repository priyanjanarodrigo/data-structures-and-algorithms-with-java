package com.myorg.practise.data_structures.linked_list.singly_linked_list;

/**
 * <h1>Node class</h1>
 * <p>Represents a single node in the linked list Each node contains a value and a reference to
 * the next node in the list.</p>
 */
public class Node {

  // Value/ data element of the node
  public int value;

  // Pointer/reference to the next node in the linked list
  public Node next;

  /**
   * Parameterized constructor to initialize a Node with the specified value.
   *
   * @param value Value to be assigned to the Node
   */
  public Node(int value) {
    this.value = value;
  }

  /**
   * Returns the String representation of a Node.
   *
   * @return String
   */
  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
