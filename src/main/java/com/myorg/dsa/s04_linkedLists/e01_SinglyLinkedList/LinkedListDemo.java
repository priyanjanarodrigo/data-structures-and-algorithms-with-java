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
