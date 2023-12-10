package com.myorg.dsa.s04_linkedLists.e01_SinglyLinkedList;

/**
 * LinkedList class : Defines a singly linked list.
 */
public class LinkedList {

  /**
   * Nested inner class Node: Defines a single node.
   */
  class Node {

    int value; // Value/ data element of the node

    Node next; // Keeps the pointer to the next node

    public Node(int value) {
      this.value = value;
    }

    /**
     * Returns the String representation of a Node.
     *
     * @return String
     */
    public String toString() {
      return String.valueOf(value);
    }
  }

  private int length; // Keeps track of the linked list

  private Node head; //  Pointer to the head of the linked list

  private Node tail; // pointer to the tail of the linked list

  // Default constructor for initializing an empty linked list
  public LinkedList() {
  }

  public LinkedList(int value) {
    Node node = new Node(value);
    head = node;
    tail = node;
    length = 1; // With the initial Node assigned as both the head and tail, the length will be 1.
  }

  /**
   * Appends a Node at the end of the linked list. If the head is null, then, both the head and tail
   * are assigned to the new Node.
   *
   * Otherwise, new Node will be assigned as the current tail's next reference and then, the tail
   * pointer will be assigned/pointed to the new Node accordingly.
   *
   * At last, the length of the linked list is incremented by 1.
   *
   * Time Complexity: O(1) [Constant Time] as we simply attach one node at the end and point the
   * tail to it. It always involves one addition of Node without iterating through the others.
   *
   * @param value Data value to be assigned to the Node.
   */
  public void append(int value) {
    Node node = new Node(value);

    // if(length == 0) and if(tail == null) are also valid checks for this.
    if (head == null) {
      head = node;
    } else {
      tail.next = node;
    }

    tail = node;
    length++;
  }

  /**
   * Attaches a Node to the starting end as the new head (the new first element/head).
   *
   * Time Complexity: O(1) [Constant Time] as we simply attach one node from the front and point the
   * head to it. It always involves one addition of Node without iterating through the others
   */
  public void prepend(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      tail = newNode;
    }

    newNode.next = head;
    head = newNode;
    length++;
  }

  /**
   * Removes the last node from the linked list and returns it. Returns null if the linked list
   * doesn't have nodes(if it is empty).
   *
   * Time Complexity: O(N) as it's required to start at the head and iterate though the list until
   * we get to the Node before tail and then set it as the tail (and then tail.next null obviously).
   * Because we had to touch all the Nodes and iterate though the list to reach for the Node before
   * tail, the time complexity becomes O(N) where N is the number of Nodes.
   *
   * @return Node
   */
  public Node removeLast() {
    if (tail == null) {
      return null;
    }

    Node currentNode = head;
    Node previousNode = head;

    while (currentNode.next != null) {
      previousNode = currentNode;
      currentNode = currentNode.next;
    }

    tail = previousNode;
    tail.next = null;
    this.length--;

    /* If the length is 0 after reducing the length from above line of code. (Which means there has
    been only 1 element in the linked list) */
    if (this.length == 0) {
      head = null;
      tail = null;
    }

    return currentNode;
  }

  /**
   * Removes the fist node from the linked list.
   *
   * @return Node
   */
  public Node removeFirst() {
    return null;
  }

  /**
   * Inserts a new Node with the provided value at the specified index.
   *
   * Time Complexity : O(N) as we have to iterate through the list in oder to reach out the
   * specified index and insert a new Node at that particular position.
   *
   * @param index Index at which the new Node is inserted
   * @param value Value of the new Node
   */
  public void insert(int index, int value) {
    // TODO: to be implemented
  }


  /**
   * Removes the specified Node at the specified index
   * @param index Index at which the Node to be removed exists
   *
   * Time Complexity : O(N) as we have to iterate through the list in oder to reach out the
   * specified index and delete the existing Node there.
   *
   * @return Node
   */
  public Node remove(int index) {
    return null; // TODO: to be implemented
  }


  /**
   * Searches the node by the given index and returns it.
   *
   * Time Complexity : O(N) as we have to iterate through the list in oder to search for the Node
   * which is available at the given index.
   *
   * @return Node
   */
  public Node lookUpByVIndex(int index) {
    return null; // TODO: to be implemented
  }


  /**
   * Searches the node by the provided value and returns it.
   *
   * Time Complexity : O(N) as we have to iterate through the list in oder to search the Node with
   * the provided value at some index and return it.
   *
   * @return Node
   */
  public Node lookUpByValue(int value) {
    return null; // TODO: to be implemented
  }

  /**
   * Returns the String representation of the LinkedList.
   *
   * @return String
   */
  @Override
  public String toString() {
    StringBuilder linkedListString = new StringBuilder("[");
    if (length > 0) {
      Node currentNode = head;
      while (currentNode != null) {
        linkedListString.append(currentNode);
        if (currentNode.next != null) {
          linkedListString.append(", ");
        }
        currentNode = currentNode.next;
      }
    }
    return linkedListString.append("]").toString();
  }

  /**
   * Prints out all the details of the linked list.
   */
  public void printAllDetails() {
    System.out.println("\n------------------------------------------");
    System.out.println("Length : " + this.length);
    System.out.println("Head : " + this.head);
    System.out.println("Tail : " + this.tail);
    System.out.println(this);
    System.out.println("------------------------------------------");
  }
}