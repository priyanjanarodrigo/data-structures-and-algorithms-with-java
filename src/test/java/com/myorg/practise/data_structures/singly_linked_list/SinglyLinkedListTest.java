package com.myorg.practise.data_structures.singly_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.myorg.practise.data_structures.linked_list.singly_linked_list.Node;
import com.myorg.practise.data_structures.linked_list.singly_linked_list.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SinglyLinkedList Test Suite")
class SinglyLinkedListTest {

  private SinglyLinkedList list;

  @BeforeEach
  void setUp() {
    list = new SinglyLinkedList();
  }

  // ============ Constructor Tests ============

  @Test
  @DisplayName("Default constructor should initialize empty list with null head and tail")
  void testDefaultConstructor() {
    assertTrue(list.isEmpty(), "New list should be empty");
    assertNull(list.head, "Head should be null for empty list");
    assertNull(list.tail, "Tail should be null for empty list");
    assertEquals(0, list.length, "Length should be 0 for empty list");
  }

  @Test
  @DisplayName("Constructor with initial value should create list with one node")
  void testConstructorWithInitialValue() {
    list = new SinglyLinkedList(5);
    assertFalse(list.isEmpty(), "List with initial value should not be empty");
    assertEquals(5, list.head.value, "Head value should match initial value");
    assertEquals(5, list.tail.value, "Tail value should match initial value");
    assertEquals(1, list.length, "Length should be 1");
    assertSame(list.head, list.tail, "Head and tail should reference same node");
  }

  // ============ isEmpty Tests ============

  @Test
  @DisplayName("isEmpty should return true for newly created list")
  void testIsEmptyOnNewList() {
    assertTrue(list.isEmpty(), "Newly created list should be empty");
  }

  @Test
  @DisplayName("isEmpty should return false after appending element")
  void testIsEmptyAfterAppend() {
    list.append(10);
    assertFalse(list.isEmpty(), "List with elements should not be empty");
  }

  @Test
  @DisplayName("isEmpty should return true after removing all elements")
  void testIsEmptyAfterRemoval() {
    list.append(10);
    list.removeFirst();
    assertTrue(list.isEmpty(), "List should be empty after removing only element");
  }

  // ============ append Tests ============

  @Test
  @DisplayName("append to empty list should set both head and tail")
  void testAppendToEmptyList() {
    list.append(5);
    assertEquals(5, list.head.value, "Head value should be appended value");
    assertEquals(5, list.tail.value, "Tail value should be appended value");
    assertEquals(1, list.length, "Length should be 1");
  }

  @Test
  @DisplayName("append multiple elements should maintain head and update tail")
  void testAppendMultipleElements() {
    list.append(1);
    list.append(2);
    list.append(3);
    assertEquals(1, list.head.value, "Head should remain first appended value");
    assertEquals(3, list.tail.value, "Tail should be last appended value");
    assertEquals(3, list.length, "Length should be 3");
    assertSame(list.head.next.next, list.tail, "Tail should be reachable via next pointers");
  }

  // ============ prepend Tests ============

  @Test
  @DisplayName("prepend to empty list should set both head and tail")
  void testPrependToEmptyList() {
    list.prepend(5);
    assertEquals(5, list.head.value, "Head value should be prepended value");
    assertEquals(5, list.tail.value, "Tail value should be prepended value");
    assertEquals(1, list.length, "Length should be 1");
  }

  @Test
  @DisplayName("prepend multiple elements should update head correctly")
  void testPrependMultipleElements() {
    list.prepend(3);
    list.prepend(2);
    list.prepend(1);
    assertEquals(1, list.head.value, "Head should be last prepended value");
    assertEquals(3, list.tail.value, "Tail should remain original value");
    assertEquals(3, list.length, "Length should be 3");
  }

  // ============ removeFirst Tests ============

  @Test
  @DisplayName("removeFirst from empty list should return null and not modify list")
  void testRemoveFirstFromEmptyList() {
    Node result = list.removeFirst();
    assertNull(result, "Removing from empty list should return null");
    assertEquals(0, list.length, "Length should remain 0");
  }

  @Test
  @DisplayName("removeFirst from single element should clear the list")
  void testRemoveFirstFromSingleElement() {
    list.append(5);
    Node removed = list.removeFirst();
    assertEquals(5, removed.value, "Removed node value should be 5");
    assertNull(removed.next, "Removed node should have null next pointer");
    assertTrue(list.isEmpty(), "List should be empty after removing only element");
  }

  @Test
  @DisplayName("removeFirst from multiple elements should update head correctly")
  void testRemoveFirstFromMultipleElements() {
    list.append(1);
    list.append(2);
    list.append(3);
    Node removed = list.removeFirst();
    assertEquals(1, removed.value, "Removed value should be 1");
    assertEquals(2, list.head.value, "New head should be 2");
    assertEquals(2, list.length, "Length should be 2");
  }

  // ============ removeLast Tests ============

  @Test
  @DisplayName("removeLast from empty list should return null")
  void testRemoveLastFromEmptyList() {
    Node result = list.removeLast();
    assertNull(result, "Removing from empty list should return null");
    assertEquals(0, list.length, "Length should remain 0");
  }

  @Test
  @DisplayName("removeLast from single element should clear the list")
  void testRemoveLastFromSingleElement() {
    list.append(5);
    Node removed = list.removeLast();
    assertEquals(5, removed.value, "Removed node value should be 5");
    assertTrue(list.isEmpty(), "List should be empty after removing only element");
  }

  @Test
  @DisplayName("removeLast from multiple elements should update tail correctly")
  void testRemoveLastFromMultipleElements() {
    list.append(1);
    list.append(2);
    list.append(3);
    Node removed = list.removeLast();
    assertEquals(3, removed.value, "Removed value should be 3");
    assertEquals(2, list.tail.value, "New tail should be 2");
    assertEquals(2, list.length, "Length should be 2");
  }

  // ============ get Tests ============

  @Test
  @DisplayName("get with negative index should return null")
  void testGetWithInvalidNegativeIndex() {
    list.append(1);
    Node result = list.get(-1);
    assertNull(result, "Getting with negative index should return null");
  }

  @Test
  @DisplayName("get with out of bounds index should return null")
  void testGetWithInvalidIndexOutOfBounds() {
    list.append(1);
    Node result = list.get(5);
    assertNull(result, "Getting beyond list length should return null");
  }

  @Test
  @DisplayName("get at index 0 should return head node")
  void testGetFirstElement() {
    list.append(1);
    list.append(2);
    Node node = list.get(0);
    assertEquals(1, node.value, "First element should be 1");
    assertSame(node, list.head, "First element should be head node");
  }

  @Test
  @DisplayName("get at last index should return tail node")
  void testGetLastElement() {
    list.append(1);
    list.append(2);
    list.append(3);
    Node node = list.get(2);
    assertEquals(3, node.value, "Last element should be 3");
    assertSame(node, list.tail, "Last element should be tail node");
  }

  @Test
  @DisplayName("get at middle index should return correct node")
  void testGetMiddleElement() {
    list.append(1);
    list.append(2);
    list.append(3);
    Node node = list.get(1);
    assertEquals(2, node.value, "Middle element should be 2");
  }

  // ============ set Tests ============

  @Test
  @DisplayName("set with invalid index should return false")
  void testSetWithInvalidIndex() {
    list.append(1);
    boolean result = list.set(5, 10);
    assertFalse(result, "Setting invalid index should return false");
  }

  @Test
  @DisplayName("set at index 0 should update head node value")
  void testSetFirstElement() {
    list.append(1);
    list.append(2);
    boolean result = list.set(0, 10);
    assertTrue(result, "Set operation should return true");
    assertEquals(10, list.head.value, "Head value should be updated to 10");
  }

  @Test
  @DisplayName("set at last index should update tail node value")
  void testSetLastElement() {
    list.append(1);
    list.append(2);
    boolean result = list.set(1, 20);
    assertTrue(result, "Set operation should return true");
    assertEquals(20, list.tail.value, "Tail value should be updated to 20");
  }

  @Test
  @DisplayName("set at middle index should update correct node value")
  void testSetMiddleElement() {
    list.append(1);
    list.append(2);
    list.append(3);
    boolean result = list.set(1, 15);
    assertTrue(result, "Set operation should return true");
    assertEquals(15, list.get(1).value, "Middle element should be updated to 15");
  }

  // ============ insert Tests ============

  @Test
  @DisplayName("insert with negative index should return false")
  void testInsertWithInvalidNegativeIndex() {
    boolean result = list.insert(-1, 5);
    assertFalse(result, "Insert with negative index should return false");
  }

  @Test
  @DisplayName("insert with out of bounds index should return false")
  void testInsertWithInvalidIndexOutOfBounds() {
    list.append(1);
    boolean result = list.insert(5, 10);
    assertFalse(result, "Insert beyond list bounds should return false");
  }

  @Test
  @DisplayName("insert at beginning should update head")
  void testInsertAtBeginning() {
    list.append(2);
    list.append(3);
    boolean result = list.insert(0, 1);
    assertTrue(result, "Insert operation should return true");
    assertEquals(1, list.head.value, "Head should be updated to 1");
    assertEquals(3, list.length, "Length should be 3");
  }

  @Test
  @DisplayName("insert at end should update tail")
  void testInsertAtEnd() {
    list.append(1);
    list.append(2);
    boolean result = list.insert(2, 3);
    assertTrue(result, "Insert operation should return true");
    assertEquals(3, list.tail.value, "Tail should be updated to 3");
    assertEquals(3, list.length, "Length should be 3");
  }

  @Test
  @DisplayName("insert in middle should maintain correct linkage")
  void testInsertInMiddle() {
    list.append(1);
    list.append(3);
    boolean result = list.insert(1, 2);
    assertTrue(result, "Insert operation should return true");
    assertEquals(2, list.get(1).value, "Element at index 1 should be 2");
    assertEquals(3, list.length, "Length should be 3");
    assertEquals(3, list.get(2).value, "Element at index 2 should be 3");
  }

  // ============ remove Tests ============

  @Test
  @DisplayName("remove with negative index should return null")
  void testRemoveWithInvalidNegativeIndex() {
    list.append(1);
    Node result = list.remove(-1);
    assertNull(result, "Remove with negative index should return null");
  }

  @Test
  @DisplayName("remove with out of bounds index should return null")
  void testRemoveWithInvalidIndexOutOfBounds() {
    list.append(1);
    Node result = list.remove(5);
    assertNull(result, "Remove beyond list bounds should return null");
  }

  @Test
  @DisplayName("remove at first index should update head")
  void testRemoveFirstIndex() {
    list.append(1);
    list.append(2);
    list.append(3);
    Node removed = list.remove(0);
    assertEquals(1, removed.value, "Removed value should be 1");
    assertEquals(2, list.head.value, "New head should be 2");
    assertEquals(2, list.length, "Length should be 2");
  }

  @Test
  @DisplayName("remove at last index should update tail")
  void testRemoveLastIndex() {
    list.append(1);
    list.append(2);
    list.append(3);
    Node removed = list.remove(2);
    assertEquals(3, removed.value, "Removed value should be 3");
    assertEquals(2, list.tail.value, "New tail should be 2");
    assertEquals(2, list.length, "Length should be 2");
  }

  @Test
  @DisplayName("remove at middle index should maintain correct linkage")
  void testRemoveMiddleIndex() {
    list.append(1);
    list.append(2);
    list.append(3);
    Node removed = list.remove(1);
    assertEquals(2, removed.value, "Removed value should be 2");
    assertEquals(3, list.get(1).value, "New element at index 1 should be 3");
    assertEquals(2, list.length, "Length should be 2");
  }

  // ============ reverse Tests ============

  @Test
  @DisplayName("reverse empty list should remain empty")
  void testReverseEmptyList() {
    list.reverse();
    assertTrue(list.isEmpty(), "Empty list should remain empty after reverse");
  }

  @Test
  @DisplayName("reverse single element should not change list")
  void testReverseSingleElement() {
    list.append(5);
    list.reverse();
    assertEquals(5, list.head.value, "Head should remain 5");
    assertEquals(5, list.tail.value, "Tail should remain 5");
    assertEquals(1, list.length, "Length should remain 1");
  }

  @Test
  @DisplayName("reverse two elements should swap head and tail")
  void testReverseTwoElements() {
    list.append(1);
    list.append(2);
    list.reverse();
    assertEquals(2, list.head.value, "Head should be 2 after reverse");
    assertEquals(1, list.tail.value, "Tail should be 1 after reverse");
    assertEquals(1, list.get(1).value, "Element at index 1 should be 1");
  }

  @Test
  @DisplayName("reverse multiple elements should reverse entire order")
  void testReverseMultipleElements() {
    list.append(1);
    list.append(2);
    list.append(3);
    list.reverse();
    assertEquals(3, list.head.value, "Head should be 3 after reverse");
    assertEquals(1, list.tail.value, "Tail should be 1 after reverse");
    assertEquals(2, list.get(1).value, "Element at index 1 should be 2");
    assertEquals(1, list.get(2).value, "Element at index 2 should be 1");
  }

  // ============ toString Tests ============

  @Test
  @DisplayName("toString empty list should return empty brackets")
  void testToStringEmptyList() {
    String result = list.toString();
    assertEquals("[]", result, "Empty list string representation should be []");
  }

  @Test
  @DisplayName("toString single element should contain element value")
  void testToStringSingleElement() {
    list.append(5);
    String result = list.toString();
    assertTrue(result.contains("5"), "String representation should contain element value");
  }

  @Test
  @DisplayName("toString multiple elements should contain all values with arrow separators")
  void testToStringMultipleElements() {
    list.append(1);
    list.append(2);
    list.append(3);
    String result = list.toString();
    assertTrue(result.contains("1"), "String should contain first element");
    assertTrue(result.contains("2"), "String should contain second element");
    assertTrue(result.contains("3"), "String should contain third element");
    assertTrue(result.contains("\u2192"), "String should contain arrow separator");
  }
}
