package com.myorg.dsa.s08_hashTable;

import java.util.ArrayList;

/**
 * HashTableDemo class: Demonstrates HashTableDemo related functionality.
 */
public class HashTableDemo {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    testInitialization();
    testHashTableFunctionalities();
  }

  public static void testInitialization() {
    HashTable hashTable = new HashTable();
    hashTable.printAllDetails();
  }

  public static void testHashTableFunctionalities() {
    HashTable hashTable = new HashTable();
    hashTable.printAllDetails();

    hashTable.set("nails", 1000);
    hashTable.set("plugs", 770);
    hashTable.set("screws", 800);
    hashTable.set("tile", 500);
    hashTable.set("nuts", 1200);
    hashTable.set("lumber", 230);
    hashTable.printAllDetails();

    System.out.println("Get the value of key - " + "\"test\"" + " : " + hashTable.get("test"));
    System.out.println("Get the value of key - " + "\"tile\"" + " : " + hashTable.get("tile"));
    System.out.println("Get the value of key - " + "\"screws\"" + " : " + hashTable.get("screws"));
    System.out.println("Get the value of key - " + "\"nuts\"" + " : " + hashTable.get("nuts"));
    System.out.println("Get the value of key - " + "\"nails\"" + " : " + hashTable.get("nails"));
    System.out.println("Get the value of key - " + "\"lumber\"" + " : " + hashTable.get("lumber"));
    System.out.println("Get the value of key - " + "\"plugs\"" + " : " + hashTable.get("plugs"));

    ArrayList<String> keysList = hashTable.keys();
    System.out.println("\nKeys List : " + keysList);
  }
}
