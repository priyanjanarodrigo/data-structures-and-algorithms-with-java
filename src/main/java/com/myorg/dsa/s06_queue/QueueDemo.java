package com.myorg.dsa.s06_queue;

/**
 * QueueDemo class : Demonstrates the functionalities of the Queue.
 */
public class QueueDemo {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    testInitializationAndEnqueue();
    testDequeue();
  }

  public static void testDequeue() {
    Queue queue = new Queue();
    queue.printAllDetails();
    System.out.println("Dequeued : " + queue.dequeue());

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.printAllDetails();

    System.out.println("Dequeued : " + queue.dequeue());
    queue.printAllDetails();

    System.out.println("Dequeued : " + queue.dequeue());
    queue.printAllDetails();

    System.out.println("Dequeued : " + queue.dequeue());
    queue.printAllDetails();

    System.out.println("Dequeued : " + queue.dequeue());
    queue.printAllDetails();
  }

  public static void testInitializationAndEnqueue() {
    Queue queue = new Queue();
    queue.printAllDetails();

    Queue queue2 = new Queue(10);
    queue2.enqueue(20);
    queue2.enqueue(30);
    queue2.enqueue(40);
    queue2.printAllDetails();
  }
}
