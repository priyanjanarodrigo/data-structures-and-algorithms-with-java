package com.myorg.practise.algorithms.binary_search;

import static com.myorg.practise.algorithms.binary_search.BinarySearch.binarySearch;
import static com.myorg.practise.algorithms.binary_search.BinarySearch.binarySearchGeneric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <h1>BinarySearchTest class</h1>
 * <p>Addresses Unit Tests for BinarySearch class.</p>
 */
@DisplayName("BinarySearch Algorithm Tests")
class BinarySearchTest {

  /* Normal Binary Search Tests ================================================================= */
  @Test
  @DisplayName("Should find element at the beginning of array")
  void testFindElementAtBeginning() {
    int[] array = {1, 3, 5, 7, 9, 11};
    int result = binarySearch(array, 1);

    assertEquals(0, result, "Element at beginning should return index 0");
  }

  @Test
  @DisplayName("Should find element at the end of array")
  void testFindElementAtEnd() {
    int[] array = {1, 3, 5, 7, 9, 11};
    int result = binarySearch(array, 11);

    assertEquals(5, result, "Element at end should return last index");
  }

  @Test
  @DisplayName("Should find element in the middle of array")
  void testFindElementInMiddle() {
    int[] array = {1, 3, 5, 7, 9, 11};
    int result = binarySearch(array, 7);

    assertEquals(3, result, "Element in middle should return correct index");
  }

  @Test
  @DisplayName("Should return -1 when element not found")
  void testElementNotFound() {
    int[] array = {1, 3, 5, 7, 9, 11};
    int result = binarySearch(array, 6);

    assertEquals(-1, result, "Non-existent element should return -1");
  }

  @Test
  @DisplayName("Should throw exception when array is null")
  void testNullArrayThrowsException() {
    assertThrows(IllegalArgumentException.class,
        () -> binarySearch(null, 5),
        "Should throw IllegalArgumentException for null array");
  }

  @Test
  @DisplayName("Should handle single element array - element found")
  void testSingleElementArrayFound() {
    int[] array = {5};
    int result = binarySearch(array, 5);

    assertEquals(0, result, "Single element matching key should return 0");
  }

  @Test
  @DisplayName("Should handle single element array - element not found")
  void testSingleElementArrayNotFound() {
    int[] array = {5};
    int result = binarySearch(array, 3);

    assertEquals(-1, result, "Single element not matching key should return -1");
  }

  @Test
  @DisplayName("Should handle empty array")
  void testEmptyArray() {
    int[] array = {};
    int result = binarySearch(array, 5);

    assertEquals(-1, result, "Empty array should return -1");
  }

  @Test
  @DisplayName("Should find element in large sorted array")
  void testLargeArray() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int result = binarySearch(array, 13);

    assertEquals(12, result, "Should correctly find element in large array");
  }

  @Test
  @DisplayName("Should handle negative numbers in array")
  void testNegativeNumbers() {
    int[] array = {-10, -5, 0, 5, 10};
    int result = binarySearch(array, -5);

    assertEquals(1, result, "Should find negative numbers correctly");
  }

  /* Generic Binary Search Tests ================================================================ */
  @Test
  @DisplayName("Should find String element at the beginning of array")
  void testBinarySearchGenericFindStringAtBeginning() {
    String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
    int result = binarySearchGeneric(array, "apple");

    assertEquals(0, result, "String at beginning should return index 0");
  }

  @Test
  @DisplayName("Should find String element at the end of array")
  void testBinarySearchGenericFindStringAtEnd() {
    String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
    int result = binarySearchGeneric(array, "elderberry");

    assertEquals(4, result, "String at end should return last index");
  }

  @Test
  @DisplayName("Should find String element in the middle of array")
  void testBinarySearchGenericFindStringInMiddle() {
    String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
    int result = binarySearchGeneric(array, "cherry");

    assertEquals(2, result, "String in middle should return correct index");
  }

  @Test
  @DisplayName("Should return -1 when String element not found")
  void testBinarySearchGenericStringElementNotFound() {
    String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
    int result = binarySearchGeneric(array, "grape");

    assertEquals(-1, result, "Non-existent String should return -1");
  }

  @Test
  @DisplayName("Should find Integer element in array")
  void testBinarySearchGenericFindIntegerElement() {
    Integer[] array = {10, 20, 30, 40, 50};
    int result = binarySearchGeneric(array, 30);

    assertEquals(2, result, "Integer element should be found at correct index");
  }

  @Test
  @DisplayName("Should find Long element in array")
  void testBinarySearchGenericFindLongElement() {
    Long[] array = {100L, 200L, 300L, 400L, 500L};
    int result = binarySearchGeneric(array, 400L);

    assertEquals(3, result, "Long element should be found at correct index");
  }

  @Test
  @DisplayName("Should find Double element in array")
  void testBinarySearchGenericFindDoubleElement() {
    Double[] array = {1.5, 2.5, 3.5, 4.5, 5.5};
    int result = binarySearchGeneric(array, 3.5);

    assertEquals(2, result, "Double element should be found at correct index");
  }

  @Test
  @DisplayName("Should throw exception when array is null")
  void testBinarySearchGenericNullArrayThrowsException() {
    assertThrows(IllegalArgumentException.class,
        () -> binarySearchGeneric(null, "test"),
        "Should throw IllegalArgumentException for null array");
  }

  @Test
  @DisplayName("Should throw exception when key is null")
  void testBinarySearchGenericNullKeyThrowsException() {
    String[] array = {"apple", "banana", "cherry"};
    assertThrows(IllegalArgumentException.class,
        () -> binarySearchGeneric(array, null),
        "Should throw IllegalArgumentException for null key");
  }

  @Test
  @DisplayName("Should handle single element array - element found")
  void testBinarySearchGenericSingleElementArrayFound() {
    String[] array = {"apple"};
    int result = binarySearchGeneric(array, "apple");

    assertEquals(0, result, "Single matching element should return index 0");
  }

  @Test
  @DisplayName("Should handle single element array - element not found")
  void testBinarySearchGenericSingleElementArrayNotFound() {
    String[] array = {"apple"};
    int result = binarySearchGeneric(array, "banana");

    assertEquals(-1, result, "Single non-matching element should return -1");
  }

  @Test
  @DisplayName("Should handle empty array")
  void testBinarySearchGenericEmptyArray() {
    String[] array = {};
    int result = binarySearchGeneric(array, "apple");

    assertEquals(-1, result, "Empty array should return -1");
  }

  @Test
  @DisplayName("Should find element in large sorted String array")
  void testBinarySearchGenericLargeStringArray() {
    String[] array = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta", "iota",
        "kappa"};
    int result = binarySearchGeneric(array, "theta");

    assertEquals(7, result, "Should find element in large sorted array");
  }

  @Test
  @DisplayName("Should work with custom Comparable class")
  void testBinarySearchGenericCustomComparableClass() {
    Person[] array = {
        new Person("Alice", 25),
        new Person("Bob", 30),
        new Person("Charlie", 35),
        new Person("Diana", 40)
    };

    int result = binarySearchGeneric(array, new Person("Charlie", 35));
    assertEquals(2, result, "Should find custom Comparable object at correct index");
  }

  /**
   * <h1>Person class</h1>
   * <p>Custom Comparable class for testing generic binary search.</p>
   */
  static class Person implements Comparable<Person> {

    private String name;

    private int age;

    /**
     * Constructor to initialize Person object.
     *
     * @param name the name of the person.
     * @param age  the age of the person.
     */
    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    /**
     * Compares this Person with another Person based on name.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object's name is less than,
     * equal to, or greater than the specified object's name.
     */
    @Override
    public int compareTo(Person other) {
      return this.name.compareTo(other.name);
    }

    /**
     * Overrides equals method for proper comparison in tests.
     *
     * @param obj the object to compare with.
     * @return true if both Person objects have the same name and age, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      Person person = (Person) obj;
      return age == person.age && name.equals(person.name);
    }

    /**
     * Overrides hashCode method to be consistent with equals.
     *
     * @return hash code based on name and age.
     */
    @Override
    public int hashCode() {
      return name.hashCode() + age;
    }
  }
}
