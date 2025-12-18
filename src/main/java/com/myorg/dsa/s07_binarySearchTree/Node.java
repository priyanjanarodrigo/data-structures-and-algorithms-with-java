package com.myorg.dsa.s07_binarySearchTree;

/*
 * Node class : represents a single node within the binary search tree. This will have the value and
 * two pointers such as left and right.
 *
 *   Node(value)
 *     /   \
 *    /     \
 *   /       \
 *  left    right
 */
public class Node {

  public int value; // Value of the Node

  public Node left; // Pointer to the left child

  public Node right; // Pointer to the right child

  /**
   * Parameterized constructor to initialize a Node with a specified value.
   *
   * @param value Value of the Node.
   */
  public Node(int value) {
    this.value = value;
  }

  /**
   * Returns a custom String representation for Node class.
   *
   * @return String
   */
  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
