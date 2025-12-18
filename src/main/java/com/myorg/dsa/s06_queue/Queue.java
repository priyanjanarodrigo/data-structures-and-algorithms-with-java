package com.myorg.dsa.s06_queue;

/**
 * Queue class : Includes the implementation of the data structure - Queue.
 *
 * <p>
 * Queue is a data structure which follows the FIFO - First In First Out approach. So, we have two
 * ends of the queue which are back and front where we enqueue items from the rear/back and dequeue
 * items from the front. (Enqueue --> [10, 20, 30, 40 50 ] --> Dequeue)
 *
 * <p>
 * We can take a queue of people at a bank to withdraw money from a counter as a real world
 * example.
 *
 * <p>
 * We can implement a queue using an array list. Enqueue or dequeue from the end of an array list
 * will have the time complexity of O(1) but enqueue or dequeue from the beginning of an array list
 * will have the time complexity of O(n). Either way there will always be one side with the time
 * complexity of O(n) and the other end will be O(1) but not both can be O(1).
 *
 * <p>
 * Also, we can use a singly linked list in order to implement a Queue. There we should not deque
 * from the tail's end as it has O(n) time complexity (which is removeLast()). Instead, we can
 * enqueue on tail's end (append() with time complexity O(1)) deque from head's end (removeFirst()
 * with the time complexity O(1)). head and tail can be referred as front and back (or first and
 * last) (Dequeue <-- [10, 20, 30, 40 50 ] <-- Enqueue)
 */
public class Queue {

  private Node front;

  private Node back;

  private int length;

  /**
   * No-args constructor to initialize an empty queue.
   */
  public Queue() {
  }

  /**
   * Parameterized constructor to initialize a Queue with an initial Node with a value assigned.
   *
   * @param value Value of the initial Node.
   */
  public Queue(int value) {
    Node newNode = new Node(value);
    front = newNode;
    back = newNode;
    length = 1;
  }

  public void printAllDetails() {
    System.out.println("\n-----------------------------------------------------------");
    System.out.println("Front : " + front);
    System.out.println("Peek : " + peek());
    System.out.println("Back : " + back);
    System.out.println("Length : " + length);
    System.out.println("isEmpty : " + isEmpty());
    System.out.println(this);
    System.out.println("-----------------------------------------------------------");
  }

  /**
   * Overriding the Object class toString() method for providing a custom String representation for
   * Queue.
   *
   * @return String
   */
  @Override
  public String toString() {
    StringBuilder queueString = new StringBuilder("[ ");
    if (front != null) {
      Node currentNode = front;

      while (currentNode != null) {
        queueString.append(currentNode);
        if (currentNode.next != null) {
          queueString.append(" <-- ");
        }
        currentNode = currentNode.next;
      }
    }

    return queueString.append(" ]").toString();
  }

  /**
   * Inserts a new Node into the queue from the back (Similar to appending a node at the end of a
   * singly linked list)
   * <p>
   * Time Complexity : O(1) as we are doing exactly the same as attaching a Node at the end of a
   * singly linked list (same as append())
   *
   * @param value Value of the new Node.
   */
  public void enqueue(int value) {
    Node newNode = new Node(value);
    if (front == null) {
      front = newNode;
    } else {
      back.next = newNode;
    }

    back = newNode;
    length++;
  }

  /**
   * Remove and return the front Node from the queue. If the queue is empty, then null will be
   * returned.
   * <p>
   * Time Complexity : O(1) as we are doing exactly the same as removing a Node from the beginning
   * of a linked list (same as removeFirst())
   *
   * @return Node
   */
  public Node dequeue() {
    if (front == null) {
      return null;
    }

    Node removedNode = front;
    if (length == 1) {
      front = null;
      back = null;
    } else {
      front = removedNode.next;
      removedNode.next = null;
    }

    length--;
    return removedNode;
  }

  /**
   * Returns the front Node without removing it from the queue.
   * <p>
   * Time Complexity : O(1) Constant time as we are performing just a single operation to return the
   * front Node.
   *
   * @return Node
   */
  public Node peek() {
    return front;
  }

  /**
   * Returns true if the queue is empty, otherwise returns false.
   * <p>
   * Time Complexity : O(1) Constant time as we are just returning if the queue is empty or not.
   *
   * @return boolean
   */
  public boolean isEmpty() {
    return length == 0;
  }
}
