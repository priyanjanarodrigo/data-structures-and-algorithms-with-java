package com.myorg.dsa.s04_linkedLists.e01_SinglyLinkedList;

/**
 * SinglyLinkedListDemo class: Is for the purpose of singly linked list functionality demonstration.
 */
public class SinglyLinkedListDemo {

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
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList(1);
    singlyLinkedList.append(2);
    singlyLinkedList.append(3);
    singlyLinkedList.append(4);
    singlyLinkedList.append(5);
    singlyLinkedList.printAllDetails();

    System.out.println("Reversing the linked list");
    singlyLinkedList.reverse();
    singlyLinkedList.printAllDetails();
  }

  public static void testRemove() {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList(1);
    singlyLinkedList.append(2);
    singlyLinkedList.append(3);
    singlyLinkedList.append(4);
    singlyLinkedList.append(5);
    singlyLinkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + -1 + " = " + singlyLinkedList.remove(-1));
    singlyLinkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 0 + " = " + singlyLinkedList.remove(0));
    singlyLinkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 2 + " = " + singlyLinkedList.remove(2));
    singlyLinkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 2 + " = " + singlyLinkedList.remove(2));
    singlyLinkedList.printAllDetails();

    System.out.println("Remove the Node at index : " + 2 + " = " + singlyLinkedList.remove(2));
  }

  public static void testInsert() {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList(33);
    singlyLinkedList.append(44);
    singlyLinkedList.append(55);
    singlyLinkedList.append(66);
    singlyLinkedList.append(77);
    singlyLinkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 11 + " at the index: " + -1 + " = " + singlyLinkedList.insert(-1, 11));
    singlyLinkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 99 + " at the index: " + 0 + " = " + singlyLinkedList.insert(0, 99));
    singlyLinkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 100 + " at the index: " + 2 + " = " + singlyLinkedList.insert(2, 100));
    singlyLinkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 200 + " at the index: " + 5 + " = " + singlyLinkedList.insert(5, 200));
    singlyLinkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 400 + " at the index: " + 8 + " = " + singlyLinkedList.insert(8, 400));
    singlyLinkedList.printAllDetails();

    System.out.println(
        "Insert value: " + 960 + " at the index: " + 10 + " = " + singlyLinkedList.insert(10, 960));
    singlyLinkedList.printAllDetails();
  }

  public static void testSet() {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList(1);
    singlyLinkedList.append(2);
    singlyLinkedList.append(3);
    singlyLinkedList.append(4);
    singlyLinkedList.append(5);
    singlyLinkedList.printAllDetails();

    System.out.println(
        "Set value: " + 666 + " at the index: " + -1 + " = " + singlyLinkedList.set(-1, 666));
    System.out.println("Set value: " + 88 + " at the index: " + 0 + " = " + singlyLinkedList.set(0, 88));
    System.out.println("Set value: " + 99 + " at the index: " + 3 + " = " + singlyLinkedList.set(3, 99));
    System.out.println(
        "Set value: " + 111 + " at the index: " + 4 + " = " + singlyLinkedList.set(4, 111));
    System.out.println(
        "Set value: " + 555 + " at the index: " + 5 + " = " + singlyLinkedList.set(5, 555));
    singlyLinkedList.printAllDetails();
  }

  public static void testGet() {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList(10);
    singlyLinkedList.append(20);
    singlyLinkedList.append(30);
    singlyLinkedList.append(40);
    singlyLinkedList.append(50);
    singlyLinkedList.printAllDetails();

    System.out.println("Node at index " + -1 + " is " + singlyLinkedList.get(-1));
    System.out.println("Node at index " + 0 + " is " + singlyLinkedList.get(0));
    System.out.println("Node at index " + 1 + " is " + singlyLinkedList.get(1));
    System.out.println("Node at index " + 2 + " is " + singlyLinkedList.get(2));
    System.out.println("Node at index " + 3 + " is " + singlyLinkedList.get(3));
    System.out.println("Node at index " + 4 + " is " + singlyLinkedList.get(4));
    System.out.println("Node at index " + 5 + " is " + singlyLinkedList.get(5));
  }

  public static void testRemoveFirst() {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    singlyLinkedList.printAllDetails();
    System.out.println("First item removed : " + singlyLinkedList.removeFirst());

    singlyLinkedList.append(1);
    singlyLinkedList.append(2);
    singlyLinkedList.append(3);
    singlyLinkedList.append(4);
    singlyLinkedList.printAllDetails();

    System.out.println("First item removed : " + singlyLinkedList.removeFirst());
    singlyLinkedList.printAllDetails();

    System.out.println("First item removed : " + singlyLinkedList.removeFirst());
    singlyLinkedList.printAllDetails();
  }

  public static void testPrepend() {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    singlyLinkedList.printAllDetails();
    singlyLinkedList.prepend(10);
    singlyLinkedList.prepend(20);
    singlyLinkedList.printAllDetails();

    SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList(44);
    singlyLinkedList2.printAllDetails();
    singlyLinkedList2.prepend(55);
    singlyLinkedList2.prepend(66);
    singlyLinkedList2.printAllDetails();
  }

  public static void testFunctionalitiesOfAnInitiallyValueAssignedLinkedList() {
    System.out.println("\ntestFunctionalitiesOfAnInitiallyValueAssignedLinkedList() =============");
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList(5);
    singlyLinkedList.printAllDetails();

    singlyLinkedList.append(10);
    singlyLinkedList.append(20);
    singlyLinkedList.append(30);
    singlyLinkedList.printAllDetails();

    System.out.println("Node Removed : " + singlyLinkedList.removeLast());
    System.out.println("Node Removed : " + singlyLinkedList.removeLast());
    singlyLinkedList.printAllDetails();
  }

  public static void testFunctionalitiesOfAnInitiallyEmptyLinkedList() {
    System.out.println("\ntestFunctionalitiesOfAnInitiallyEmptyLinkedList() =====================");
    SinglyLinkedList secondSinglyLinkedList = new SinglyLinkedList();
    secondSinglyLinkedList.printAllDetails();

    secondSinglyLinkedList.append(33);
    secondSinglyLinkedList.append(66);
    secondSinglyLinkedList.append(77);
    secondSinglyLinkedList.printAllDetails();

    System.out.println("Node Removed : " + secondSinglyLinkedList.removeLast());
    System.out.println("Node Removed : " + secondSinglyLinkedList.removeLast());
    secondSinglyLinkedList.printAllDetails();
  }

  public static void removingLastNodeFromAnEmptyLinkedList() {
    System.out.println("\nremovingLastNodeFromAnEmptyLinkedList() ===============================");
    SinglyLinkedList emptySinglyLinkedList = new SinglyLinkedList();
    System.out.println(emptySinglyLinkedList.removeLast());
  }

  public static void removingLastNodeFromAnLinkedListWithOneNode() {
    System.out.println("\nremovingLastNodeFromAnLinkedListWithOneNode() =========================");
    SinglyLinkedList singlyLinkedListWithOneNode = new SinglyLinkedList(2);
    singlyLinkedListWithOneNode.printAllDetails();
    System.out.println("Node Removed : " + singlyLinkedListWithOneNode.removeLast());
    singlyLinkedListWithOneNode.printAllDetails();
  }
}
