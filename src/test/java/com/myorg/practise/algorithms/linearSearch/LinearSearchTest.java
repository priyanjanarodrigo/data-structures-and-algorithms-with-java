package com.myorg.practise.algorithms.linearSearch;

import static com.myorg.practise.algorithms.linear_search.LinearSearch.performLinearSearch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * LinearSearchTest: Addresses Unit Tests for LinearSearch class.
 */
@DisplayName("LinearSearch class Related Unit Tests")
class LinearSearchTest {

  public static final int FIRST_ELEMENT = 5;
  public static final int FIRST_ELEMENT_INDEX = 0;
  public static final int LAST_ELEMENT = 34;
  public static final int LAST_ELEMENT_INDEX = 8;
  public static final int MIDDLE_ELEMENT = -13;
  public static final int MIDDLE_ELEMENT_INDEX = 4;
  public static final int VALID_ELEMENT = 88;
  public static final int VALID_ELEMENT_INDEX = 7;
  public static final int UNAVAILABLE_POSITIVE_KEY = 100;
  public static final int UNAVAILABLE_NEGATIVE_KEY = -45;
  public static final int NOT_FOUND_INDEX = -1;
  public static final String NULL_POINTER_EXCEPTION_MESSAGE = "The provided array is null";

  public static final int[] VALID_ARRAY = {
      FIRST_ELEMENT, 23, 3, 232, MIDDLE_ELEMENT, 9, 3, VALID_ELEMENT, LAST_ELEMENT};

  @Test
  @DisplayName("Perform linear search on a valid array with a valid available keys")
  void testPerformLinearSearch_withValidArrayAndValidAvailableKeys() {
    assertEquals(FIRST_ELEMENT_INDEX, performLinearSearch(VALID_ARRAY, FIRST_ELEMENT),
        "Should return index of the first element");

    assertEquals(MIDDLE_ELEMENT_INDEX, performLinearSearch(VALID_ARRAY, MIDDLE_ELEMENT),
        "Should return index of middle element");

    assertEquals(VALID_ELEMENT_INDEX, performLinearSearch(VALID_ARRAY, VALID_ELEMENT),
        "Should return index of the valid element resides somewhere else in the array");

    assertEquals(LAST_ELEMENT_INDEX, performLinearSearch(VALID_ARRAY, LAST_ELEMENT),
        "Should return index of last element");
  }

  @Test
  @DisplayName("Perform linear search on a valid array with a valid unavailable keys")
  void testPerformLinearSearch_withValidArrayAndValidUnavailableKeys() {
    assertEquals(NOT_FOUND_INDEX, performLinearSearch(VALID_ARRAY, UNAVAILABLE_POSITIVE_KEY),
        "Should return -1 when element not found");

    assertEquals(NOT_FOUND_INDEX, performLinearSearch(VALID_ARRAY, UNAVAILABLE_NEGATIVE_KEY),
        "Should return -1 when element not found");
  }

  @Test
  @DisplayName("Perform linear search on a null array with a valid key")
  void testPerformLinearSearch_withNullArrayInputAndValidKey() {
    NullPointerException nullPointerException = assertThrows(
        NullPointerException.class, () -> performLinearSearch(null, VALID_ELEMENT));
    
    assertEquals(NULL_POINTER_EXCEPTION_MESSAGE, nullPointerException.getMessage());
  }

  @Test
  @DisplayName("Perform linear search on an empty array with a valid key")
  void testPerformLinearSearch_withEmptyArrayAndValidKey() {
    assertEquals(NOT_FOUND_INDEX, performLinearSearch(new int[]{}, VALID_ELEMENT),
        "Should return -1 when element not found");
  }
}

