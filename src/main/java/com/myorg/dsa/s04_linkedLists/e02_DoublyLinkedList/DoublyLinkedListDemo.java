package com.myorg.dsa.s04_linkedLists.e02_DoublyLinkedList;


/**
 * DoublyLinkedListDemo class is for the demonstration purpose of DoublyLinkedList functionalities.
 */
public class DoublyLinkedListDemo {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    testInitializationAndAppend();
    testPrepend();
    testRemoveLast();
    testRemoveFirst();
    testGet();
    testSet();
    testInsert();
    testRemove();
  }

  public static void testRemove() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.printAllDetails();
    System.out.println("Remove item at index " + 0 + " : " + doublyLinkedList.remove(0));

    doublyLinkedList.append(1);
    doublyLinkedList.append(2);
    doublyLinkedList.append(3);
    doublyLinkedList.append(4);
    doublyLinkedList.append(5);
    doublyLinkedList.printAllDetails();

    System.out.println("Remove item at index " + 0 + " : " + doublyLinkedList.remove(0));
    doublyLinkedList.printAllDetails();

    System.out.println("Remove item at index " + 3 + " : " + doublyLinkedList.remove(3));
    doublyLinkedList.printAllDetails();

    System.out.println("Remove item at index " + 1 + " : " + doublyLinkedList.remove(1));
    doublyLinkedList.printAllDetails();

    System.out.println("Remove item at index " + 20 + " : " + doublyLinkedList.remove(20));
    doublyLinkedList.printAllDetails();
  }

  public static void testInsert() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.printAllDetails();

    System.out.println(
        "Inserting a new node with value " + 11 + " at the index " + 0 + " : "
            + doublyLinkedList.insert(
            0, 11));
    doublyLinkedList.printAllDetails();
    System.out.println(
        "Inserting a new node with value " + 22 + " at the index " + 1 + " : "
            + doublyLinkedList.insert(
            1, 22));
    doublyLinkedList.printAllDetails();

    System.out.println(
        "Inserting a new node with value " + 55 + " at the index " + 1 + " : "
            + doublyLinkedList.insert(
            1, 55));
    doublyLinkedList.printAllDetails();
  }

  public static void testSet() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.printAllDetails();
    System.out.println(
        "Set/replace the existing value of node at index " + 0 + " as " + 10 + " : "
            + doublyLinkedList.set(
            0, 10));

    doublyLinkedList.append(11);
    doublyLinkedList.append(33);
    doublyLinkedList.printAllDetails();

    System.out.println(
        "Set/replace the existing value of node at index " + 1 + " as " + 22 + " : "
            + doublyLinkedList.set(
            1, 22));
    doublyLinkedList.printAllDetails();
    System.out.println(
        "Set/replace the existing value of node at index " + 0 + " as " + 10 + " : "
            + doublyLinkedList.set(
            0, 10));
    doublyLinkedList.printAllDetails();

  }

  public static void testGet() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.printAllDetails();
    System.out.println("Node at index " + 0 + " is : " + doublyLinkedList.get(0));

    doublyLinkedList.append(23);
    doublyLinkedList.append(54);
    doublyLinkedList.append(65);
    doublyLinkedList.append(11);
    doublyLinkedList.append(87);
    doublyLinkedList.append(60);
    doublyLinkedList.printAllDetails();

    System.out.println("Node at index " + -1 + " is : " + doublyLinkedList.get(-1));
    System.out.println("Node at index " + 6 + " is : " + doublyLinkedList.get(6));
    System.out.println("Node at index " + 0 + " is : " + doublyLinkedList.get(0));
    System.out.println("Node at index " + 1 + " is : " + doublyLinkedList.get(1));
    System.out.println("Node at index " + 2 + " is : " + doublyLinkedList.get(2));
    System.out.println("Node at index " + 3 + " is : " + doublyLinkedList.get(3));
    System.out.println("Node at index " + 4 + " is : " + doublyLinkedList.get(4));
    System.out.println("Node at index " + 5 + " is : " + doublyLinkedList.get(5));

  }

  public static void testRemoveFirst() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.printAllDetails();
    System.out.println("Removing first item : " + doublyLinkedList.removeFirst());

    doublyLinkedList.append(1);
    doublyLinkedList.printAllDetails();
    System.out.println("Removing first item : " + doublyLinkedList.removeFirst());
    doublyLinkedList.printAllDetails();

    doublyLinkedList.append(2);
    doublyLinkedList.append(3);
    doublyLinkedList.append(4);
    doublyLinkedList.append(5);
    doublyLinkedList.printAllDetails();
    System.out.println("Removing first item : " + doublyLinkedList.removeFirst());
    doublyLinkedList.printAllDetails();
    System.out.println("Removing first item : " + doublyLinkedList.removeFirst());
    doublyLinkedList.printAllDetails();
  }

  public static void testRemoveLast() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.append(1);
    doublyLinkedList.printAllDetails();
    System.out.println("Removing last item : " + doublyLinkedList.removeLast());
    doublyLinkedList.printAllDetails();

    doublyLinkedList.append(2);
    doublyLinkedList.append(3);
    doublyLinkedList.append(4);
    doublyLinkedList.printAllDetails();

    System.out.println("Removing last item : " + doublyLinkedList.removeLast());
    doublyLinkedList.printAllDetails();
    System.out.println("Removing last item : " + doublyLinkedList.removeLast());
    doublyLinkedList.printAllDetails();

    DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList();
    doublyLinkedList2.printAllDetails();

    System.out.println("Removing last item : " + doublyLinkedList.removeLast());
    doublyLinkedList2.printAllDetails();
  }

  public static void testPrepend() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.prepend(1);
    doublyLinkedList.prepend(2);
    doublyLinkedList.prepend(3);
    doublyLinkedList.printAllDetails();
    System.out.println("head.next : " + doublyLinkedList.head.next);
    System.out.println("head.prev : " + doublyLinkedList.head.prev);
    System.out.println("tail.next : " + doublyLinkedList.tail.next);
    System.out.println("tail.prev : " + doublyLinkedList.tail.prev);

    DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList(22);
    doublyLinkedList2.prepend(33);
    doublyLinkedList2.prepend(44);
    doublyLinkedList2.prepend(55);
    doublyLinkedList2.printAllDetails();
    System.out.println("head.next : " + doublyLinkedList2.head.next);
    System.out.println("head.prev : " + doublyLinkedList2.head.prev);
    System.out.println("tail.next : " + doublyLinkedList2.tail.next);
    System.out.println("tail.prev : " + doublyLinkedList2.tail.prev);
  }

  public static void testInitializationAndAppend() {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.append(1);
    doublyLinkedList.append(2);
    doublyLinkedList.append(3);
    doublyLinkedList.printAllDetails();
    System.out.println("head.next : " + doublyLinkedList.head.next);
    System.out.println("head.prev : " + doublyLinkedList.head.prev);
    System.out.println("tail.next : " + doublyLinkedList.tail.next);
    System.out.println("tail.prev : " + doublyLinkedList.tail.prev);

    DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList(22);
    doublyLinkedList2.append(33);
    doublyLinkedList2.append(44);
    doublyLinkedList2.append(55);
    doublyLinkedList2.printAllDetails();
    System.out.println("head.next : " + doublyLinkedList2.head.next);
    System.out.println("head.prev : " + doublyLinkedList2.head.prev);
    System.out.println("tail.next : " + doublyLinkedList2.tail.next);
    System.out.println("tail.prev : " + doublyLinkedList2.tail.prev);
  }
}
