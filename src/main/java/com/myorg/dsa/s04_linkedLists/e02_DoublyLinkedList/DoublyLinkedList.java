package com.myorg.dsa.s04_linkedLists.e02_DoublyLinkedList;

/**
 * DoublyLinkedList class: Composes a doubly linked list with relevant attributes and behaviours.
 */
public class DoublyLinkedList {

  public Node head;

  public Node tail;

  public int length;

  /**
   * Default constructor to initialize an empty DoublyLinkedList
   */
  public DoublyLinkedList() {
  }

  /**
   * Parameterized constructor to initialize a DoublyLinkedList with first Node.
   *
   * @param value Value of the first node/head to be assigned.
   */
  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  /**
   * Overriding object class toString() to provide a custom String representation for this
   * DoublyLinkedList class.
   *
   * @return String.
   */
  @Override
  public String toString() {
    StringBuilder doublyLinkedListString = new StringBuilder("[ ");

    if (head != null) {
      Node currentNode = head;
      while (currentNode != null) {
        doublyLinkedListString.append(currentNode);
        if (currentNode.next != null) {
          doublyLinkedListString.append(", ");
        }
        currentNode = currentNode.next;
      }
    }

    return doublyLinkedListString.append(" ]").toString();
  }


  /**
   * Prints out all the details/insights related to DoublyLinkedList.
   */
  public void printAllDetails() {
    System.out.println("\n-------------------------------------------------------");
    System.out.println("Length : " + length);
    System.out.println("Head : " + head);
    System.out.println("Tail : " + tail);
    System.out.println(this);
    System.out.println("-------------------------------------------------------");
  }


  /**
   * Appends a new Node at the end of the DoublyLinkedList.
   * <p>
   * Time Complexity : O(1), which is constant time as it's required to perform just a single
   * operation in order to append a new Node at the end of the DoublyLinkedList. Here it is not
   * required to iterate though the list.
   *
   * @param value Value of the Node to be assigned.
   */
  public void append(int value) {
    Node newNode = new Node(value);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
    }

    tail = newNode;
    length++;
  }

  /**
   * Attaches a new node in the beginning of the DoublyLinkedList as the new head.
   * <p>
   * Time Complexity : O(1), which is constant time as it's required to perform just a single
   * operation in order to attach a new Node in the beginning of the DoublyLinkedList. Here it is
   * not required to iterate though the list.
   *
   * @param value Value of the Node which is attached.
   */
  public void prepend(int value) {
    Node newNode = new Node(value);

    if (head == null) {
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
    }

    head = newNode;
    length++;
  }

  /**
   * Removes the last Node from the DoublyLinkedList and returns it.
   * <p>
   * Time Complexity : O(1), which is constant time as it's required to perform just a single
   * operation in order to remove the last Node located at the end of the DoublyLinkedList. Here it
   * is not required to iterate though the list just like in a SinglyLinkedList as tail has a
   * pointer called prev which is pointing to the Node just before the last Node/ tail.
   *
   * @return Node
   */
  public Node removeLast() {
    if (head == null) {
      return null;
    }

    Node lastNode = tail;

    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
      lastNode.prev = null;
    }

    length--;
    return lastNode;
  }

  /**
   * Removes the first Node from the DoublyLinkedList and returns it.
   * <p>
   * Time Complexity : O(1), which is constant time as it's required to perform just a single
   * operation in order to remove the first Node located in the beginning of the DoublyLinkedList.
   *
   * @return Node
   */
  public Node removeFirst() {
    if (head == null) {
      return null;
    }

    Node firstNode = head;

    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
      firstNode.next = null;
    }

    length--;
    return firstNode;
  }

  /**
   * Finds and returns the Node located at the given index. If the index is not within the valid
   * range, then, null will be returned.
   * <p>
   * Time Complexity : O(n), proportional to the data set size as we have to iterate through the
   * list in order to find the Node at a particular index. (Technically it is O(n/2) and after
   * removing the constant 2 it will be O(n) at the end of the day).
   *
   * @param index Index at which the Node is searched for.
   * @return Node
   */
  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    /*
     * Here, in order to optimize the performance of this get method logic, if the given index is
     * within the first half of the DoublyLinedList (index < (length/2)), then, we start the
     * iteration from the head. (we can navigate forward with .next of each Node)
     *
     * If the given index is available within the second half of the DoublyLinedList, then we start
     * the iteration backwards from the tail. (we can navigate backwards with .prev of each Node.)
     *
     * Ex: Given the DoublyLinkedList = [ 91, 2, 34, 64, 5, 6, 117, 8, 9, 45 ], where the length of
     * it is 10, if we look for the index 2 (which is Node 34), it is much closer to head and more
     * optimized if we start the iteration from the head to reach for it.
     *
     * On the other hand, if we look for the index 7 (which is Node 8),it is not optimized if we
     * start iteration from the head (7 steps). Instead, we can iterate backwards starting from the
     * tail and that would be reduced number of steps to reach for that particular index. (2 steps)
     */

    Node currentNode;

    // if the index is within the first half
    if (index < length / 2) {
      currentNode = head;

      // Forward iteration starting from the head
      for (int i = 0; i < index; i++) {
        currentNode = currentNode.next;
      }
    } else { // if the index is within the second half
      currentNode = tail;

      // Backward iteration starting from the tail
      for (int i = length - 1; i > index; i--) {
        currentNode = currentNode.prev;
      }
    }

    return currentNode;
  }

  /**
   * Sets/replaces the existing value of the Node (which is located at the specified index) with the
   * provided new value. If the Node is not found at the given location, then false will be
   * returned.
   * <p>
   * Time Complexity : O(n), proportional to the data set size as we leverage existing get(int
   * index) method inside this method to iterate through the list in order to find the Node at a
   * particular index. (Technically it is O(n/2) and after removing the constant 2 it will be O(n)
   * at the end of the day).
   *
   * @param index Index at which the existing Node is expected to have positioned.
   * @param value The value which is replaced.
   * @return boolean.
   */
  public boolean set(int index, int value) {
    Node existingNodeAtIndex = get(index); // Leveraging the existing get method

    if (existingNodeAtIndex != null) { // If there's an existing node available at the index
      existingNodeAtIndex.value = value;
      return true;
    }
    return false;
  }

  /**
   * Inserts a new Node at the specified index and returns true if the insertion is successful.
   * Otherwise, returns false.
   * <p>
   * Time Complexity : O(n), proportional to the data set size as we leverage existing get(int
   * index) method inside this method to iterate through the list in order to find the Node at a
   * particular index. (Technically it is O(n/2) and after removing the constant 2 it will be O(n)
   * at the end of the day).
   * <p>
   * Here append, and prepend may have O(1) time complexity but in the other case where it is
   * required to leverage get(int index) method, the time complexity will be O(n) so it becomes the
   * dominant term. So the non-dominant terms are removed/ ignored.
   *
   * @param index Index at which the new Node is positioned
   * @param value Value of the new Node.
   * @return boolean
   */
  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }

    if (index == 0) {
      prepend(value); // Leveraging prepend method to insert in the beginning
    } else if (index == length) {
      append(value);  // Leveraging prepend method to append at the end
    } else {
      Node newNode = new Node(value);
      Node before = get(index - 1); // Node available before the given index
      Node after = before.next; // Node currently available at the given index

      // placing the newNode between the above 2 Nodes
      newNode.prev = before;
      before.next = newNode;

      newNode.next = after;
      after.prev = newNode;
      length++; // Length is manually incremented here only as prepend and append implicitly increase it
    }

    return true;
  }

  /**
   * Removes and returns the Node positioned at the provided index. If there's no such Node
   * available at the specified index, then null will be returned.
   * <p>
   * Time Complexity : O(n), proportional to the data set size as we leverage existing get(int
   * index) method inside this method to iterate through the list in order to find the Node at a
   * particular index. (Technically it is O(n/2) and after removing the constant 2 it will be O(n)
   * at the end of the day).
   * <p>
   * Here removeFirst, and removeLast may have O(1) time complexity but in the other case where it
   * is required to leverage get(int index) method, the time complexity will be O(n) so it becomes
   * the dominant term. So the non-dominant terms are removed/ ignored.
   *
   * @param index Index at which the Node which is to be removed is positioned
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
      removedNode = get(index);

      removedNode.next.prev = removedNode.prev;
      removedNode.prev.next = removedNode.next;
      removedNode.next = null;
      removedNode.prev = null;

      /*
       * More readable approach (but more memory is consumed) :
       *
       * Node before = removedNode.prev;
       * Node after = removedNode.next;
       * before.next = after;
       * after.prev = before;
       * removedNode.next = null;
       * removedNode.prev = null;
       */

      length--; // Length is manually decremented here only as removeFirst and removeLast implicitly decrease it
    }

    return removedNode;
  }

  // INTERVIEW QUESTIONS ==========================================================================

  /*
   * 1) Palindrome Checker
   * =====================
   *  Write a method to determine whether a given doubly linked list reads the same forwards and
   *  backwards.
   *
   *  For example, if the list contains the values [1, 2, 3, 2, 1], then the method should return
   *  true, since the list is a palindrome.
   *
   *  If the list contains the values [1, 2, 3, 4, 5], then the method should return false, since
   *  the list is not a palindrome.
   *
   *  Method name: isPalindrome
   *  Return Type: boolean
   */
  public boolean isPalindrome() {
    // If the list is empty or has only one node, it is considered a palindrome
    if (length <= 1) {
      return true;
    }

    Node start = head;
    Node end = tail;

    /*
     * The second condition "start.prev != end" is included as an additional safeguard to handle
     * cases where the list has an even number of elements, ensuring that the loop stops before
     * start and end cross over each other.
     */
    while (start != end && start.prev != end) {
      if (start.value != end.value) {
        return false;
      }
      start = start.next;
      end = end.prev;
    }
    return true;
  }
}
