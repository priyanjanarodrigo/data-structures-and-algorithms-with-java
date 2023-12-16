package com.myorg.dsa.s04_linkedLists.e01_SinglyLinkedList;

/**
 * SinglyLinkedList class : Defines a singly linked list.
 */
public class SinglyLinkedList {

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
  public SinglyLinkedList() {
  }

  public SinglyLinkedList(int value) {
    Node node = new Node(value);
    head = node;
    tail = node;
    length = 1; // With the initial Node assigned as both the head and tail, the length will be 1.
  }

  /**
   * Appends a Node at the end of the linked list. If the head is null, then, both the head and tail
   * are assigned to the new Node.
   * <p>
   * Otherwise, new Node will be assigned as the current tail's next reference and then, the tail
   * pointer will be assigned/pointed to the new Node accordingly.
   * <p>
   * At last, the length of the linked list is incremented by 1.
   * <p>
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
   * <p>
   * Time Complexity: O(1) [Constant Time] as we simply attach one node from the front and point the
   * head to it. It always involves one addition of Node without iterating through the others
   */
  public void prepend(int value) {
    Node newNode = new Node(value);

    if (head == null) {
      tail = newNode;
    } else {
      newNode.next = head;
    }

    head = newNode;
    length++;
  }

  /**
   * Removes the last node from the linked list and returns it. Returns null if the linked list
   * doesn't have nodes(if it is empty).
   * <p>
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
    if (length == 0) {
      head = null;
      tail = null;
    }

    return currentNode;
  }

  /**
   * Removes the fist node from the linked list and returns it. In case if the length == 0 (head
   * ==null), then, null will be returned.
   * <p>
   * Time Complexity: O(1) [Constant Time] as we simply remove the first node. No iteration is
   * involved here.
   *
   * @return Node
   */
  public Node removeFirst() {
    if (head == null) {
      return null;
    }

    Node previousHead = head;
    head = head.next;
    previousHead.next = null;
    length--;

    if (length == 0) {
      tail = null;
    }

    return previousHead;
  }

  /**
   * Sets the provided value to the node which is located at the specified index.
   * <p>
   * In case if an invalid index is provided (if the index is less than 0 or greater than or equals
   * to the length of the linked list), then it returns false. (leveraging get method validations)
   * <p>
   * Time Complexity : O(N) as we have to iterate through the list in oder to reach out the
   * specified index and set a new value to an existing Node at that particular index.
   *
   * @param index Index at which the new Node is inserted
   * @param value Value of the new Node
   * @return boolean
   */
  public boolean set(int index, int value) {
    Node nodeAtIndex = get(index); // We leverage the functionality of get method here

    if (nodeAtIndex != null) {
      nodeAtIndex.value = value;
      return true;
    }

    return false;
  }

  /**
   * Inserts a new node with the specified value at a particular index.
   * <p>
   * Time Complexity : O(N) as we have to iterate through the list in oder to reach out the
   * specified index and insert a new Node at that particular position.
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
      // Inserting before the existing head
      prepend(value);
    } else if (index == length) {
      // Inserting a new Node after the existing tail
      append(value);
    } else {
      Node newNode = new Node(value);
      // Fetches the node before the index to which the new Node is inserted to
      Node nodeBeforeIndex = get(index - 1);
      newNode.next = nodeBeforeIndex.next;
      nodeBeforeIndex.next = newNode;
      length++; // for above 2 if conditions, the length is incremented implicitly within prepend or append
    }

    return true;
  }

  /**
   * Removes the specified Node at the specified index.
   * <p>
   * Time Complexity : O(N) as we have to iterate through the list in oder to reach out the
   * specified index and delete the existing Node there.
   *
   * @param index Index at which the Node to be removed exists
   * @return Node
   */
  public Node remove(int index) {
    if (index < 0 || index >= length) {
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
   * Searches the node by the given index and returns it.(lookup by index).
   * <p>
   * If the provided index is out of bounds, then, "null" will be returned immediately.
   * <p>
   * Time Complexity : O(N) as we have to iterate through the list in oder to search for the Node
   * which is available at the given index.
   *
   * @return Node
   */
  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    Node currentNode = head;

    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    return currentNode;
  }

  /**
   * Reverses the SinglyLinkedList in place without making any duplicate copies of it.
   */
  public void reverse() {
    // Switching the head and tail
    Node temp = head;
    head = tail;
    tail = temp;

    // Reversing back the Node.next
    Node after = temp.next;
    Node before = null;

    for (int i = 0; i < length; i++) {
      after = temp.next; // In the first iteration, this is already the status
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  /**
   * Returns the String representation of the SinglyLinkedList.
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
