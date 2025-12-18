package com.myorg.dsa.s05_stack;

import java.util.ArrayList;

/**
 * Stack class : Includes the implementation of the data structure - Stack.
 * <p>
 * Stack is a data structure which follows the LIFO - Last In First Out policy. So we add and remove
 * items from the same end of the stack. We can take a can of tennis balls as a real world example
 * for the stack.
 * <p>
 * We can implement a stack by using an arraylist, so we can leverage add() and remove() methods
 * which have O(1) constant time complexity when it comes to Big O. it is important to perform these
 * operations at the end of the array list. if we perform these from the front, due to re indexing,
 * the time complexity will become O(n).
 * <p>
 * We can also use a singly linked list to implement a Stack. But, importantly is better to consider
 * inserting and removing items from the side of head in terms of time complexity, as both the
 * removeFirst() and prepend() have O(1) constant time complexity. In case if we perform add and
 * remove from tail's side, append() will be O(1) but removeLast() will become O(n). Therefore,
 * removing from the tail's end will not be efficient.
 * <p>
 * In here, we have used the singly linked list based approach to implement the Stack.
 */
public class Stack {

  private Node top; // We need only the head as we are not dealing from the tail's side. We refer this as top

  private int height; // This simply is the size of the Stack

  /**
   * No-args constructor in order to initialize an empty stack.
   */
  public Stack() {
  }

  /**
   * Parameterized constructor which initializes a Stack with the initial Node
   *
   * @param value Value of the initial Node
   */
  public Stack(int value) {
    Node newNode = new Node(value);
    top = newNode;
    height = 1;
  }

  /**
   * Prints out all the details related to the Stack.
   */
  public void printAllDetails() {
    System.out.println("\n--------------------------------------------");
    System.out.println("Top : " + top);
    System.out.println("Peek : " + peek());
    System.out.println("Height : " + height);
    System.out.println("isEmpty : " + isEmpty() + "\n");
    printStack();
    System.out.println("--------------------------------------------");
  }

  /**
   * Prints out the stack structure.
   */
  public void printStack() {
    if (height == 0) {
      System.out.println("|   |");
      System.out.println("-----");
    }

    Node currentNode = top;
    while (currentNode != null) {
      System.out.println("| " + currentNode + " |");
      System.out.println("------");
      currentNode = currentNode.next;
    }
  }

  /**
   * Adds a new Node to the top of the stack.
   * <p>
   * Time Complexity : O(1) Constant time as we are leveraging the same append functionality of a
   * singly linked list.
   *
   * @param value Value of the new Node to be inserted on top.
   */
  public void push(int value) {
    Node newNode = new Node(value);

    if (top != null) {
      newNode.next = top;
    }

    top = newNode;
    height++;
  }

  /**
   * Remove and returns the first Node/ top Node from the stack. If the Stack is empty, then null
   * will be returned.
   * <p>
   * Time Complexity : O(1) Constant time as we are leveraging the same removeFirst functionality of
   * a singly linked list.
   *
   * @return Node
   */
  public Node pop() {
    if (isEmpty()) {
      return null;
    }

    Node removedNode = top;
    top = removedNode.next;
    removedNode.next = null;
    height--;
    return removedNode;
  }

  /**
   * Returns the top Node without removing it.
   * <p>
   * Time Complexity : O(1) Constant time as we are performing a single operation by just returning
   * the top Node.
   *
   * @return Node
   */
  public Node peek() {
    return top;
  }

  /**
   * Returns true if the stack is empty, otherwise returns false.
   * <p>
   * Time Complexity : O(1) Constant time as we are performing a single operation just to check the
   * height (or if the top is null or not)
   *
   * @return Node
   */
  public boolean isEmpty() {
    return top == null;
  }
}
