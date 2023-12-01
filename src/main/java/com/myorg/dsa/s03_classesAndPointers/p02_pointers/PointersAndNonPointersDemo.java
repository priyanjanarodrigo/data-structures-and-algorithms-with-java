package com.myorg.dsa.s03_classesAndPointers.p02_pointers;

import java.util.HashMap;

/**
 * PointersAndNonPointersDemo class demonstrates the difference between non-pointers and pointers.
 */
public class PointersAndNonPointersDemo {

  /**
   * Java main method.
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {

    /** 1). Non-Pointers ======================================================================== */
    int num1 = 11;
    int num2 = num1; // Assigning the value of num2 to num1

    /*
     * 1.1). At this stage following is how the num1 and num2 have been assigned with values
     *
     *  num1 ==> 11
     *  num2 ==> 11
     */

    num1 = 33; // This change will not be reflected to num2

    /*
     * 1.2). At this stage following is how the num1 and num2 have been assigned with values
     *
     *  num1 ==> 33
     *  num2 ==> 11
     */

    System.out.println("num1 = " + num1); //  33
    System.out.println("num2 = " + num2); // 11 (Changes to num1 after the initial assignment has not reflected)


    /** 2). Pointers ============================================================================ */
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();

    /*
     * 2.1). At this stage following is how the map1 and map2 are pointing to their respective objects
     *
     *   map1 ----> {}
     *   map2 ----> {}
     */

    map1.put("key1", 11);

    /*
     * Here map2 is pointed to map1 object and any updates to map1 object state even after this
     * assignment, will immediately be reflected to map2 as both are pointing to the same object.
     */
    map2 = map1;

    /*
     * 2.2). At this stage following is how the map1 and map2 are pointing to the same
     *
     *   map1 ---------->  { "key1" = 11 }
     *                          ^
     *                          |
     *              ------------|
     *              |
     *   map2 ------|      {}
     */

    map1.put("key1", 22); // Replacing the value of initially defined key "key1"

    /*
     * 2.3). At this stage following is how the map1 and map2 are already pointing to the same object even if the object state has been changed.
     *
     *   map1 ---------->  { "key1" = 22 }
     *                          ^
     *                          |
     *              ------------|
     *              |
     *   map2 ------|      {}
     */

    System.out.println(map1); // { "key1" : 22 }
    System.out.println(map2); // { "key1" : 22 } (Changes to map1 after the initial assignment has reflected)
  }
}
