package com.myorg.dsa.s04_linkedLists.e01_SinglyLinkedList;

/**
 * LinkedListDemo class: Is for the purpose of singly linked list functionality demonstration.
 */
public class LinkedListDemo {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    testFunctionalitiesOfAnInitiallyValueAssignedLinkedList();
    testFunctionalitiesOfAnInitiallyEmptyLinkedList();
    removingLastNodeFromAnEmptyLinkedList();
    removingLastNodeFromAnLinkedListWithOneNode();
    testPrepend();
    testRemoveFirst();
    testGet();
    testSet();
    testInsert();
    testRemove();
    testReverse();
  }

  public static void testReverse() {
    LinkedList linkedList = new LinkedList(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.append(5);
    linkedList.printAllDetails();

    System.out.println("Reversing the linked list");
    linkedList.reverse();
    linkedList.printAllDetails();
  }

  public static void testRemove() {
    LinkedList linkedList = new LinkedList(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.append(5);
    linkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + -1 + " = " + linkedList.remove(-1));
    linkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 0 + " = " + linkedList.remove(0));
    linkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 2 + " = " + linkedList.remove(2));
    linkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 2 + " = " + linkedList.remove(2));
    linkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 2 + " = " + linkedList.remove(2));
  }

  public static void testInsert() {
    LinkedList linkedList = new LinkedList(33);
    linkedList.append(44);
    linkedList.append(55);
    linkedList.append(66);
    linkedList.append(77);
    linkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 11 + " at the index: " + -1 + " = " + linkedList.insert(-1, 11));
    linkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 99 + " at the index: " + 0 + " = " + linkedList.insert(0, 99));
    linkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 100 + " at the index: " + 2 + " = " + linkedList.insert(2, 100));
    linkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 200 + " at the index: " + 5 + " = " + linkedList.insert(5, 200));
    linkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 400 + " at the index: " + 8 + " = " + linkedList.insert(8, 400));
    linkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 960 + " at the index: " + 10 + " = " + linkedList.insert(10, 960));
    linkedList.printAllDetails();
  }

  public static void testSet() {
    LinkedList linkedList = new LinkedList(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.append(5);
    linkedList.printAllDetails();

    System.out.println(
        "Set value: " + 666 + " at the index: " + -1 + " = " + linkedList.set(-1, 666));
    System.out.println("Set value: " + 88 + " at the index: " + 0 + " = " + linkedList.set(0, 88));
    System.out.println("Set value: " + 99 + " at the index: " + 3 + " = " + linkedList.set(3, 99));
    System.out.println(
        "Set value: " + 111 + " at the index: " + 4 + " = " + linkedList.set(4, 111));
    System.out.println(
        "Set value: " + 555 + " at the index: " + 5 + " = " + linkedList.set(5, 555));
    linkedList.printAllDetails();
  }

  public static void testGet() {
    LinkedList linkedList = new LinkedList(10);
    linkedList.append(20);
    linkedList.append(30);
    linkedList.append(40);
    linkedList.append(50);
    linkedList.printAllDetails();

    System.out.println("Node at index " + -1 + " is " + linkedList.get(-1));
    System.out.println("Node at index " + 0 + " is " + linkedList.get(0));
    System.out.println("Node at index " + 1 + " is " + linkedList.get(1));
    System.out.println("Node at index " + 2 + " is " + linkedList.get(2));
    System.out.println("Node at index " + 3 + " is " + linkedList.get(3));
    System.out.println("Node at index " + 4 + " is " + linkedList.get(4));
    System.out.println("Node at index " + 5 + " is " + linkedList.get(5));
  }

  public static void testRemoveFirst() {
    LinkedList linkedList = new LinkedList();
    linkedList.printAllDetails();
    System.out.println("First item removed : " + linkedList.removeFirst());

    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.printAllDetails();

    System.out.println("First item removed : " + linkedList.removeFirst());
    linkedList.printAllDetails();

    System.out.println("First item removed : " + linkedList.removeFirst());
    linkedList.printAllDetails();
  }

  public static void testPrepend() {
    LinkedList linkedList = new LinkedList();
    linkedList.printAllDetails();
    linkedList.prepend(10);
    linkedList.prepend(20);
    linkedList.printAllDetails();

    LinkedList linkedList2 = new LinkedList(44);
    linkedList2.printAllDetails();
    linkedList2.prepend(55);
    linkedList2.prepend(66);
    linkedList2.printAllDetails();
  }

  public static void testFunctionalitiesOfAnInitiallyValueAssignedLinkedList() {
    System.out.println("\ntestFunctionalitiesOfAnInitiallyValueAssignedLinkedList() =============");
    LinkedList linkedList = new LinkedList(5);
    linkedList.printAllDetails();

    linkedList.append(10);
    linkedList.append(20);
    linkedList.append(30);
    linkedList.printAllDetails();

    System.out.println("Node Removed : " + linkedList.removeLast());
    System.out.println("Node Removed : " + linkedList.removeLast());
    linkedList.printAllDetails();
  }

  public static void testFunctionalitiesOfAnInitiallyEmptyLinkedList() {
    System.out.println("\ntestFunctionalitiesOfAnInitiallyEmptyLinkedList() =====================");
    LinkedList secondLinkedList = new LinkedList();
    secondLinkedList.printAllDetails();

    secondLinkedList.append(33);
    secondLinkedList.append(66);
    secondLinkedList.append(77);
    secondLinkedList.printAllDetails();

    System.out.println("Node Removed : " + secondLinkedList.removeLast());
    System.out.println("Node Removed : " + secondLinkedList.removeLast());
    secondLinkedList.printAllDetails();
  }

  public static void removingLastNodeFromAnEmptyLinkedList() {
    System.out.println("\nremovingLastNodeFromAnEmptyLinkedList() ===============================");
    LinkedList emptyLinkedList = new LinkedList();
    System.out.println(emptyLinkedList.removeLast());
  }

  public static void removingLastNodeFromAnLinkedListWithOneNode() {
    System.out.println("\nremovingLastNodeFromAnLinkedListWithOneNode() =========================");
    LinkedList linkedListWithOneNode = new LinkedList(2);
    linkedListWithOneNode.printAllDetails();
    System.out.println("Node Removed : " + linkedListWithOneNode.removeLast());
    linkedListWithOneNode.printAllDetails();
  }
}
