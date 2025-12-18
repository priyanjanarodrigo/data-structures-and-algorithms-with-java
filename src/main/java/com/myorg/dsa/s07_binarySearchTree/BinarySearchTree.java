package com.myorg.dsa.s07_binarySearchTree;

/*
 * BinarySearchTree class: Composes binary search tree data structure related functionality.
 *
 * Important Points:
 * -----------------
 * - A binary tree is made of nodes where each node has its state/value and two pointers such as
 *   left and right. Which means each node can point only to two other nodes and that's what makes
 *   it a binary tree. That's the rule for a binary tree.
 *
 * - There are 3 different types of binary trees
 *
 *      1. Full Binary Tree : Every Node other than leaf nodes has 2 child nodes.
 *                            In simple terms, in a full tree, every node either points to 0 nodes
 *                            or 2 nodes.
 *
 *            10
 *           /  \
 *          5   20
 *         / \
 *        2   8
 *
 *      2. Complete Binary Tree : All levels are filled except possibly the last one, and all nodes
 *                                are filled in as far left as possible. Here we are filling the
 *                                tree from left to right with no gaps.
 *
 *             10
 *           /    \
 *          5      20
 *         / \    /
 *        2   8  12
 *
 *
 *      3. Perfect Binary Tree : All nodes have two children and all leaves are at the same level.
 *                               In simple terms, any level in the tree that has any node is
 *                               completely filled all the way across.
 *
 *             10
 *           /    \
 *          5      20
 *         / \    /  \
 *        2   8  12   25
 */
public class BinarySearchTree {

  // root should be private, and we have kept it as public for testing purpose only
  public Node root; // Defines the top element of the tree which is the root Nod.

  /**
   * Inserts a new Node to the binary search tree. The position in the BST to which the new Node is
   * attached, is evaluated based on its value. Once attached, "true" will be returned. Otherwise,
   * if the new Node value already exists, then the new Node will not be attached and false will be
   * returned immediately.
   *
   * @param value Value of the new Node.
   * @return boolean
   */
  public boolean insert(int value) {
    Node newNode = new Node(value);

    // If the root Node is null, which means that the BST is empty. Therefore, new node is assigned as the root node.
    if (root == null) {
      root = newNode;
      return true;
    }

    // Setting the root Node as the initial current Node
    Node currentNode = root;

    // This loop will continue running until the new Node is properly placed and attached to the tree
    while (true) {
      /* We can't insert a value that we already have in the BinarySearchTree. Therefore,
       * a duplicate value is not inserted and returns false immediately */
      if (newNode.value == currentNode.value) {
        return false;
      }

      // If the value of the new node is less than the current node value, then the new node is moved to the left side
      if (newNode.value < currentNode.value) {
        // Checks if the left branch of the current Node is null and if so, new Node is attached as the left Node of the current Node
        if (currentNode.left == null) {
          currentNode.left = newNode;
          return true;
        }

        // Otherwise, move the current Node pointer to the left Node of the current Node
        currentNode = currentNode.left;
      } else { // Else, if the value of the new node is greater than the current node value, then the new node is moved to the right side

        // Checks if the right branch of the current Node is null and if so, new Node is attached as the right Node of the current Node
        if (currentNode.right == null) {
          currentNode.right = newNode;
          return true;
        }

        // Otherwise, move the current Node pointer to the right Node of the current Node
        currentNode = currentNode.right;
      }
    }
  }
  
  /**
   * Returns true if the Binary Search Tree contains the given value. Otherwise returns false.
   *
   * @param value Value to be searched for.
   * @return boolean.
   */
  public boolean contains(int value) {

    // This is optional as null check is happening below. if root is null, then while loop will not be executed and immediately returns false
    if (root == null) {
      return false;
    }

    Node currentNode = root;

    while (currentNode != null) {
      if (value == currentNode.value) {
        return true;
      }

      if (value < currentNode.value) {
        currentNode = currentNode.left;
      } else {
        currentNode = currentNode.right;
      }
    }
    return false;
  }
}
