package com.myorg.practise.data_structures.linked_list.singly_linked_list;

/**
 * <h1>SinglyLinkedList class</h1>
 * <p>Defines the structure and functionalities of a singly linked list data structure</p>
 */
public class SinglyLinkedList {

  // Head pointer of the linked list
  public Node head;

  // Tail pointer of the linked list
  public Node tail;

  // Length of the linked list
  public int length;

  /**
   * Default constructor/ No-arg constructor for initializing an empty linked list.
   */
  public SinglyLinkedList() {
  }

  /**
   * Parameterized constructor which initializes a SinglyLinkedList with the initial node with
   * specified value.
   *
   * @param initialNodeValue Value of the initial node.
   */
  public SinglyLinkedList(int initialNodeValue) {
    Node node = new Node(initialNodeValue);
    this.head = node;
    this.tail = node;
    this.length++;
  }

  /**
   * Checks if the linked list is empty.
   *
   * @return true if the linked list is empty, false otherwise.
   */
  public boolean isEmpty() {
    return length == 0 && head == null && tail == null;
  }

  /**
   * Returns the String representation of the linked list.
   *
   * @return String
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");

    Node current = head;
    while (current != null) {
      sb.append(current);
      if (current.next != null) {
        sb.append(" \u2192 "); // Unicode arrow symbol →
      }

      current = current.next;
    }
    return sb.append("]").toString();
  }

  /**
   * Prints all the details of the linked list including head, tail, length and the list itself.
   */
  public void printDetails() {
    System.out.println("Head: " + head);
    System.out.println("Tail: " + tail);
    System.out.println("Length: " + length);
    System.out.println("List: " + this + "\n");
  }

  /**
   * Appends a new node with the specified value at the end of the linked list.
   *
   * @param value Value of the new node to be appended.
   */
  public void append(int value) {
    Node newNode = new Node(value);

    if (isEmpty()) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    length++;
  }

  /**
   * Prepends a new node with the specified value at the beginning of the linked list.
   *
   * @param value Value of the new node to be prepended.
   */
  public void prepend(int value) {
    Node newNode = new Node(value);

    if (isEmpty()) {
      tail = newNode;
    } else {
      newNode.next = head;
    }

    head = newNode;
    length++;
  }

  /**
   * Removes and returns the first node of the linked list.
   *
   * @return The removed node, or null if the list is empty.
   */
  public Node removeFirst() {
    if (isEmpty()) {
      return null;
    }

    Node removedNode = head;

    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
    }

    removedNode.next = null;
    length--;
    return removedNode;
  }

  /**
   * Removes and returns the last node of the linked list.
   *
   * @return The removed node, or null if the list is empty.
   */
  public Node removeLast() {
    if (isEmpty()) {
      return null;
    }

    Node removedNode = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      Node current = head;

      while (current.next != tail) {
        current = current.next;
      }

      current.next = null;
      tail = current;
    }

    length--;
    return removedNode;
  }

  /**
   * Retrieves the node at the specified index.
   *
   * @param index Index of the node to retrieve.
   * @return The node at the specified index, or null if the index is out of bounds.
   */
  public Node get(int index) {
    if (index < 0 || index > length - 1) {
      return null;
    }

    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    return current;
  }

  /**
   * Updates the value of the node at the specified index.
   *
   * @param index Index of the node to update.
   * @param value New value to set.
   * @return true if the update was successful, false if the index is out of bounds.
   */
  public boolean set(int index, int value) {
    Node targetNode = get(index);

    if (targetNode != null) {
      targetNode.value = value;
      return true;
    }

    return false;
  }

  /**
   * Inserts a new node with the specified value at the specified index.
   *
   * @param index Index at which the new Node is inserted
   * @param value Value of the new Node
   * @return boolean
   */
  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }

    if (index == 0) {
      prepend(value);
    } else if (index == length) {
      append(value);
    } else {
      Node newNode = new Node(value);
      Node nodeBeforeIndex = get(index - 1);
      newNode.next = nodeBeforeIndex.next;
      nodeBeforeIndex.next = newNode;
      length++;
    }

    return true;
  }

  /**
   * Removes the specified Node at the specified index.
   *
   * @param index Index at which the Node to be removed exists
   * @return Node
   */
  public Node remove(int index) {
    if (index < 0 || index > length - 1) {
      return null;
    }

    Node removedNode;
    if (index == 0) {
      removedNode = removeFirst();
    } else if (index == length - 1) {
      removedNode = removeLast();
    } else {
      Node previousNode = get(index - 1);
      removedNode = previousNode.next;
      previousNode.next = removedNode.next;
      removedNode.next = null;
      length--;
    }
    return removedNode;
  }

  /**
   * Reverses the linked list in place.
   */
  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;

    Node after;
    Node before = null;

    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }
}
