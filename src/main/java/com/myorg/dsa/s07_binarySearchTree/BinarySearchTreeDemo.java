package com.myorg.dsa.s07_binarySearchTree;

/**
 * BinarySearchTreeDemo class: Demonstrates the functionalities related to the data structure -
 * Binary Search Tree.
 */
public class BinarySearchTreeDemo {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    testInitialization();
    testInsertion();
    testContains();
  }

  public static void testInsertion() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(47);
    binarySearchTree.insert(21);
    binarySearchTree.insert(76);
    binarySearchTree.insert(18);
    binarySearchTree.insert(52);
    binarySearchTree.insert(82);

    binarySearchTree.insert(27);

    System.out.println(binarySearchTree.root.left.right.value);
  }


  public static void testContains() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    System.out.println("root : " + binarySearchTree.root + "\n");

    System.out.println("Adding root node value " + 50 + " : " + binarySearchTree.insert(50));
    System.out.println("root : " + binarySearchTree.root + "\n");

    System.out.println(
        "Adding duplicated root node value " + 50 + " : " + binarySearchTree.insert(50) + "\n");

    System.out.println("Adding new node with value " + 45 + " : " + binarySearchTree.insert(45));
    System.out.println("Adding new node with value " + 50 + " : " + binarySearchTree.insert(48));

    System.out.println("Adding new node with value " + 55 + " : " + binarySearchTree.insert(55));
    System.out.println("Adding new node with value " + 70 + " : " + binarySearchTree.insert(70));
    System.out.println("Adding new node with value " + 53 + " : " + binarySearchTree.insert(53));
    System.out.println("Adding new node with value " + 15 + " : " + binarySearchTree.insert(15));
    System.out.println("Adding new node with value " + 10 + " : " + binarySearchTree.insert(10));
    System.out.println("Adding new node with value " + 30 + " : " + binarySearchTree.insert(30));
    System.out.println("Adding new node with value " + 46 + " : " + binarySearchTree.insert(46));
    System.out.println("Adding new node with value " + 49 + " : " + binarySearchTree.insert(49));
    System.out.println("Adding new node with value " + 51 + " : " + binarySearchTree.insert(51));
    System.out.println("Adding new node with value " + 54 + " : " + binarySearchTree.insert(54));
    System.out.println("Adding new node with value " + 60 + " : " + binarySearchTree.insert(60));
    System.out.println("Adding new node with value " + 80 + " : " + binarySearchTree.insert(80));

    System.out.println(
        "Adding duplicated node value " + 60 + " : " + binarySearchTree.insert(60));
    System.out.println(
        "Adding duplicated node value " + 49 + " : " + binarySearchTree.insert(49) + "\n");

    printFourLevels(binarySearchTree);

    System.out.println("Contains " + 100 + " : " + binarySearchTree.contains(100));

    System.out.println("Contains " + 50 + " : " + binarySearchTree.contains(50));
    System.out.println("Contains " + 45 + " : " + binarySearchTree.contains(45));

    System.out.println("Contains " + 55 + " : " + binarySearchTree.contains(55));
    System.out.println("Contains " + 15 + " : " + binarySearchTree.contains(15));
    System.out.println("Contains " + 48 + " : " + binarySearchTree.contains(48));
    System.out.println("Contains " + 53 + " : " + binarySearchTree.contains(53));
    System.out.println("Contains " + 70 + " : " + binarySearchTree.contains(70));

    System.out.println("Contains " + 10 + " : " + binarySearchTree.contains(10));
    System.out.println("Contains " + 30 + " : " + binarySearchTree.contains(30));
    System.out.println("Contains " + 46 + " : " + binarySearchTree.contains(46));
    System.out.println("Contains " + 49 + " : " + binarySearchTree.contains(49));
    System.out.println("Contains " + 51 + " : " + binarySearchTree.contains(51));
    System.out.println("Contains " + 54 + " : " + binarySearchTree.contains(54));
    System.out.println("Contains " + 60 + " : " + binarySearchTree.contains(60));
    System.out.println("Contains " + 80 + " : " + binarySearchTree.contains(80));

    System.out.println("\n\nNew Binary search tree --------------\n");
    binarySearchTree = new BinarySearchTree();
    System.out.println("Contains " + 10 + " : " + binarySearchTree.contains(10));
    System.out.println("Adding new node with value " + 33 + " : " + binarySearchTree.insert(33));
    System.out.println("Contains " + 35 + " : " + binarySearchTree.contains(35));

    System.out.println("Adding new node with value " + 48 + " : " + binarySearchTree.insert(48));
    System.out.println("Adding new node with value " + 45 + " : " + binarySearchTree.insert(45));
    System.out.println("Contains " + 45 + " : " + binarySearchTree.contains(45));



  }

  public static void testInitialization() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    System.out.println("root : " + binarySearchTree.root);
  }

  public static void printFourLevels(BinarySearchTree bst) {
    System.out.println("                    " + bst.root.value);
    System.out.println("                 /      \\");
    System.out.println("               /          \\");
    System.out.println("             /              \\");
    System.out.println("           /                   \\");
    System.out.println("         " + bst.root.left + "                     " + bst.root.right);
    System.out.println("       /    \\                 /     \\ ");
    System.out.println("     /        \\             /         \\ ");
    System.out.println(
        "   " + bst.root.left.left + "          " + bst.root.left.right + "          "
            + bst.root.right.left + "          " + bst.root.right.right);
    System.out.println("  /   \\       /   \\       /   \\       /   \\");
    System.out.println(
        bst.root.left.left.left + "    " + bst.root.left.left.right + "    "
            + bst.root.left.right.left + "    " + bst.root.left.right.right + "    "
            + bst.root.right.left.left + "    " + bst.root.right.left.right + "    "
            + bst.root.right.right.left + "    " + bst.root.right.right.right + "  " + "\n");
  }
}
