package com.myorg.dsa.s03_classes_and_pointers.p02_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <h1>PointersAndNonPointersDemo class</h1>
 * <p>demonstrates the difference between non-pointers and pointers.</p>
 */
public class PointersAndNonPointersDemo {

  /**
   * <h2>Java main method</h2>
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {

    /* 1). Non-Pointers ========================================================================= */
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

    System.out.println("num1 = " + num1); // Output: 33

    // Output: 11 (Changes to num1 after the initial assignment has not reflected)
    System.out.println("num2 = " + num2);
    System.out.println();

    /* 2). Pointers ============================================================================= */
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();

    /*
     * 2.1). At this stage following is how the map1 and map2 are pointing to their respective
     *       objects.
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
     * 2.3). At this stage following is how the map1 and map2 are already pointing to the same
     *       object even if the object state has been changed.
     *
     *
     *   map1 ---------->  { "key1" = 22 }
     *                          ^
     *                          |
     *              ------------|
     *              |
     *   map2 ------|      {}
     */

    // { "key1" : 22 }
    System.out.println(map1);

    // { "key1" : 22 } (Changes to map1 after the initial assignment has reflected) */
    System.out.println(map2);
    System.out.println();

    /* 3). Pointers with Lists ==================================================================
     *
     * Here both list1 and list2 are pointing to the same List object in the memory. Any changes to
     * the List object through either list1 or list2 will be reflected in both references.
     */
    List<Integer> list1 = new ArrayList<>();
    list1.add(11);
    list1.add(22);

    /*
     * At this stage following is how the list1 and list2 are pointing to the same List object
     *    list1 --------------> [11, 22]
     *                             ^
     *                             |
     *    list2  ------------------|
     */

    List<Integer> list2 = list1;
    list2.add(33);// Adding an element to the list via list2 reference

    /*
     * At this stage following is how the list1 and list2 are pointing to the same List object
     *    list1 --------------> [11, 22, 33]
     *                             ^
     *                             |
     *    list2  ------------------|
     * */

    list1.removeFirst(); // removing the first element from list1

    /*
     * At this stage following is how the list1 and list2 are pointing to the same List object
     *   list1 --------------> [22, 33]
     *                            ^
     *                            |
     *   list2  ------------------|
     */

    System.out.println(list1);
    System.out.println(list2);
    System.out.println();

    /*
     * IMPORTANT !!
     * =============================================================================================
     *
     * When dealing with non-pointers (primitives), changes to one variable don't affect another.
     *
     * However, with pointers (reference types), multiple references can point to the same object,
     * and changes through one reference will be reflected in all references pointing to that
     * object.
     *
     * Immutable objects (like String in Java) behave differently. When you modify a String, a new
     * String object is created, and references to the original String remain unchanged.
     *
     * The following are Java immutable objects:
     *  - String
     *  - Wrapper classes (Integer, Double, Boolean, etc.)
     *  - BigInteger and BigDecimal
     *  - LocalDate, LocalTime, LocalDateTime (from java.time package)
     *  - Records (introduced in Java 14)
     *
     * The following are Java mutable objects:
     *  - All collection classes (ArrayList, HashMap, HashSet, etc.)
     *  - Custom classes with setter methods or public fields
     *  - Arrays
     *
     * The following example demonstrates immutable behavior of String objects
     */
    String str1 = "Hello";
    String str2 = str1; // str2 points to the same String object as str1
    str1 = str1 + " World"; // Creates a new String object for str1

    System.out.println("str1 = " + str1); // Outputs: Hello World
    System.out.println("str2 = " + str2); // Outputs: Hello (remains unchanged)
  }
}
