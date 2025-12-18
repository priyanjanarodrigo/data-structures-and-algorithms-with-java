package com.myorg.dsa.s08_hashTable;

import java.util.ArrayList;

/*
 * HashTable class: Structures properties and methods for the data structure - HashTable.
 *
 * =================================================================================================
 * > INTRODUCTION:
 * =================================================================================================
 *
 * > Consider the Hash table as an array as follows:
 *
 *  -------------------------
 *  |                   |   |
 *  |                   | 0 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 1 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 2 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 3 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 4 |
 *  -------------------------
 *
 * > When we run the hash on the key "nails" in the key-value pair : { "nails" =1000 },
 *   (Every character in the key has an ASCII value and the Hash method runs some calculation on
 *   them), it runs through the hash, we get an address and the key-value pair itself as well.
 *
 *                                                  |---->  2
 *       { "nails"=1000 }   ----- [HASH_METHOD] ----|
 *                                                  |---->  { "nails"=1000 }
 *
 * > So this address (2 in the above example) is going to be one of the indexes in the array and
 *   that's where we store our key-value pair. (take a look at the following diagram)
 *
 *  -------------------------
 *  |                   |   |
 *  |                   | 0 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 1 |
 *  -------------------------
 *  |                   |   |
 *  | {"nails":1000}    | 2 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 3 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 4 |
 *  -------------------------
 *
 * > Characteristics of Hash method:
 *    1) One Way.
 *        So when we have a key like "nails", we run it through the hash method, and we get an
 *        address. But we cannot do it the other way. Which means that we cannot run the address 2
 *        through the hash method backwards and regenerate the key "nails".
 *
 *    2) Deterministic
 *        Means that every single time we run the same key through the hash method, it always
 *        returns the same address.
 *
 * > High level set method : set(String key, int value)
 *
 * > Collitions
 *    { "nails"=1000 }  ----- [HASH_METHOD] ----> 2 , { "nails"=1000 }
 *    { "screws"=800 }  ----- [HASH_METHOD] ----> 6 , { "screws"=1200 }
 *    { "nuts"=1200 }   ----- [HASH_METHOD] ----> 2 , { "nuts"=1200 }
 *    { "bolts"=1400 }  ----- [HASH_METHOD] ----> 4 , { "bolts"=1400 }
 *
 *
 *    Here for the keys "nails" and "nuts", the same address is returned by the hash method. We can
 *    identify this as a collition. In that case, we do not override the index 2 and completely
 *    replace the existing {"nails"=1000} key-value pair with { "nuts"=1200 }.
 *
 *    Instead, we want to be able to keep them both. There are multiple ways for storing multiple items at a particular address
 *
 *  -------------------------
 *  |                   |   |
 *  |                   | 0 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 1 |
 *  -------------------------
 *  | {"nails":1000}    |   |
 *  | {"nuts":1200}     | 2 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 3 |
 *  -------------------------
 *  |                   |   |
 *  | {"bolts"=1400}    | 4 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 5 |
 *  -------------------------
 *  |                   |   |
 *  | {"screws"=800}    | 6 |
 *  -------------------------
 *
 * > High level get method : get(String key)
 *
 * > For collitions, we may have to navigate through the ket-value pairs in the index at which
 *   multiple values have been stored and then return the requested value.
 *
 * =================================================================================================
 * > COLLITIONS:
 * =================================================================================================
 *
 *  1) Separate Chaining :
 *      Putting the next key-value pair at the same address where the address is already having an
 *      existing key-value pair
 *
 *  -------------------------
 *  |                   |   |
 *  |                   | 0 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 1 |
 *  -------------------------
 *  | {"nails":1000}    |   |
 *  | {"nuts":1200}     | 2 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 3 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 4 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 5 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 6 |
 *  -------------------------
 *
 * 2) Linear Probing: (One of the types of Open Addressing)
 *      If there's an item already there at the index where we want to put some other key-value pair,
 *      you just go to the next open spot and put the value there. Likewise, everytime this collition
 *      happens, we just navigate/ keep going (in case if the next spot is also filled up) and look
 *      for an open spot, and put the value there.
 *
 *  -------------------------
 *  |                   |   |
 *  |                   | 0 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 1 |
 *  -------------------------
 *  | {"nails":1000}    |   |   Already Exist <------- (1) --------- {"nuts":1200}
 *  |                   | 2 |     |
 *  -------------------------    (2)
 *  |                   |   |     |
 *  | {"nuts":1200}     | 3 | <---- Move to the next available spot and put it there
 *  -------------------------
 *  |                   |   |
 *  |                   | 4 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 5 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 6 |
 *  -------------------------
 *
 *  - In our example, we are going to use Separate Chaining. (Keep all with the same address in one
 *    address). We are going to achieve this is by having a linked list at each one of these
 *    addresses. So Linked List a common way of implementing Separate Chaining.
 *
 *  -------------------------
 *  |                   |   |
 *  |                   | 0 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 1 |
 *  -------------------------
 *  |      -------------|---|---> {"nails":1000} ---> {"nuts":1200} ---> {"paint":2300}
 *  |                   | 2 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 3 |
 *  -------------------------
 *  |      -------------|---|---> {"bolts"=1400}
 *  |                   | 4 |
 *  -------------------------
 *  |                   |   |
 *  |                   | 5 |
 *  -------------------------
 *  |      -------------|---|---> {"screws"=800}
 *  |                   | 6 |
 *  -------------------------
 *
 */
public class HashTable {

  // Size of the hash table address base (this can be changed based on the requirement).
  private int size = 7;

  // Data map array of type Node[]. When we set something to type Node, it is a pointer to a Node. This is an array of pointers to Nodes (a Singly Linked List)
  private Node[] dataMap;

  /**
   * No-args constructor which initializes a new hasTable with the data map/address base of the
   * defined size.
   */
  public HashTable() {
    dataMap = new Node[size];
  }

  /**
   * Returns the customized String representation of HashTable.
   *
   * @return String.
   */
  @Override
  public String toString() {
    StringBuilder hashTableString = new StringBuilder("[\n");

    for (int i = 0; i < dataMap.length; i++) {
      hashTableString.append("\t" + i + " : [");
      if (dataMap[i] != null) {

        Node currentNode = dataMap[i];
        while (currentNode != null) {
          hashTableString.append("{ " + currentNode.key + " : " + currentNode.value + " }");
          if (currentNode.next != null) {
            hashTableString.append(" --> ");
          }
          currentNode = currentNode.next;
        }
      }
      hashTableString.append("]\n");
    }

    return hashTableString.append("]").toString();
  }

  /**
   * Prints out all the details related to the HashTable
   */
  public void printAllDetails() {
    System.out.println("\n-----------------------------------------------------------------------");
    System.out.println("Address Base Size : " + size);
    System.out.println(this);
    System.out.println("-----------------------------------------------------------------------");
  }


  /**
   * Hashes the provided key and returns a guaranteed address base index for it to be stored within
   * the range of 0 to dataMap.length-1. This is basically the hash method, and it should be
   * declared as private because this functionality is directly utilized only by the other methods
   * within the HasTable class (this class).
   *
   * <p>
   * Time Complexity : O(1) Constant time, because the hash method is going to go through the same
   * number of operations to determine a hash regardless of the number of items that are already
   * available in the hash table. (Not the number of characters available within the key String)
   *
   * @param key Key to be hashed
   * @return int
   */
  private int hash(String key) {
    int hash = 0;
    char[] keyChars = key.toCharArray();

    for (char keyChar : keyChars) {
      // When a character is assigned to an int, it will assign the ascii value of it.
      int asciiValue = keyChar;

      /*
       * 1) We have used 25 here but can be any prime number.
       *
       * 2) Usage of modulus -> VALUE % 7 will always return a remainder with in the
       *    minimum range of 0 and maximum range of 6, exactly as we need it within the index range
       *    of the dataMap array/ address base. So the inclusive rage of 0 to 6 is always guaranteed.
       */
      hash = (hash + asciiValue * 25) % dataMap.length;
    }

    return hash;
  }

  /**
   * Sets a new Node at some particular index of the data map which is decided by the returned index
   * value by the hash method.
   *
   * <p>
   * If the index returned by the hash method already contains some node (which is technically a
   * singly linked list),then the new Node will be appended to it. If the index is null (means there
   * is no existing Node), then, the new node will be assigned to that particular index
   * immediately.
   *
   * <p>
   * Time Complexity : O(1) Constant time as it fetches the hash index and stores a new Node there,
   * which is a single operation.
   *
   * @param key   Key value through which the hash is generated
   * @param value Value of the new node
   */
  public void set(String key, int value) {
    int index = hash(key); // Retrieving the index based on the hash of the key
    Node newNode = new Node(key, value);

    if (dataMap[index] == null) {
      dataMap[index] = newNode;
    } else {
      Node currentNode = dataMap[index];

      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }

      currentNode.next = newNode;
    }
  }

  /**
   * Returns the value associated with the provided key. If the value does not exist, then, 0 will
   * be returned.
   *
   * <p>
   * Time Complexity : O(1), it is consuming a single operation to get the value of a particular
   * node at some index determined by the hash.
   * <p>
   * The thing is that when we are dealing with a HashTable, the assumption is going to be that hash
   * method is going to create random addresses and out hash table is going to look like something
   * where there are no many Nodes within a single index. With a larger address base/ dataMap and
   * more randomization of hash index, this will not be a big deal.
   * <p>
   * Due to this, we consider getting an item and also setting an item as O(1) constant time.
   *
   * @param key The key to be used to obtain the value
   * @return int
   */
  public int get(String key) {
    int index = hash(key); // Determines the index where we would expect to find the given key

    Node currentNode = dataMap[index];

    // while loop will break out if the currentNode is null and 0 will be returned
    while (currentNode != null) {
//      if (key == currentNode.key) {
      if (key.equals(currentNode.key)) {
        return currentNode.value;
      }
      currentNode = currentNode.next;
    }

    return 0;
  }

  /**
   * Returns all the keys available within the HashTable.
   *
   * @return List<String>
   */
  public ArrayList<String> keys() {
    ArrayList<String> allKeys = new ArrayList<>();

    // looping through the entire dataMap array
    for (Node node : dataMap) {

      // Accessing internal singly linked list Nodes it the index is not null
      if (node != null) {
        Node currentNode = node;
        // Go through the linked list to access all the available Nodes
        while (currentNode != null) {
          allKeys.add(currentNode.key);
          currentNode = currentNode.next;
        }
      }
    }
    return allKeys;
  }
}
