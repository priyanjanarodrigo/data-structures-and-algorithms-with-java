package com.myorg.dsa.s05_stack;

/**
 * StackDemo class : Demonstrates the functionalities of the Stack.
 */
public class StackDemo {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    /* testInitialization();
    testPush(); */
    testPop();
  }

  public static void testPop() {
    Stack stack = new Stack();
    stack.printAllDetails();

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.printAllDetails();

    System.out.println("pop() executed : " + stack.pop());
    stack.printAllDetails();

    System.out.println("pop() executed : " + stack.pop());
    stack.printAllDetails();

    System.out.println("pop() executed : " + stack.pop());
    stack.printAllDetails();
  }

  public static void testPush() {
    Stack stack = new Stack();
    stack.printAllDetails();

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.printAllDetails();

    Stack stack2 = new Stack(99);
    stack2.push(88);
    stack2.push(77);
    stack2.push(66);
    stack2.printAllDetails();
  }

  public static void testInitialization() {
    Stack stack = new Stack(10);
    stack.printAllDetails();

    Stack emptyStack = new Stack();
    emptyStack.printAllDetails();
  }
}
