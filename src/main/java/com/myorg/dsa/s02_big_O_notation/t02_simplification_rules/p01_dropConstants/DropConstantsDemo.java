package com.myorg.dsa.s02_big_O_notation.t02_simplification_rules.p01_dropConstants;

/**
 * <h1>DropConstantsDemo class : Demonstrates Big O Simplification Rule - Drop Constants</h1>
 */
public class DropConstantsDemo {

  /**
   * <h2>Big O Simplification: Drop Constants Rule - O(n)</h2>
   * <hr>
   * <p>
   * Demonstrates the "Drop Constants" simplification rule in Big O notation analysis. This method
   * prints elements twice sequentially, illustrating how multiple linear operations collapse into a
   * single O(n) complexity.
   * </p>
   *
   * <p>
   * <b>Algorithm Breakdown:</b>
   * </p>
   * <ul>
   *   <li><b>First loop:</b> Executes n times → O(n) operations</li>
   *   <li><b>Second loop:</b> Executes n times → O(n) operations</li>
   *   <li><b>Total operations:</b> n + n = 2n operations</li>
   * </ul>
   *
   * <p>
   * <b>Big O Simplification Process:</b>
   * </p>
   * <pre>
   * Step 1: Count total operations
   *         O(n + n) = O(2n)
   *
   * Step 2: Drop constant coefficients (constants become irrelevant at scale)
   *         O(2n) ====DROP CONSTANTS====> O(n)
   *
   * Step 3: Simplified Big O notation
   *         Final Complexity = O(n) Linear Time
   * </pre>
   *
   * <p>
   * <b>Why Drop Constants?</b>
   * <br>
   * Constants (like 2, 10, 100) become negligible as n grows large. Whether you perform 1n or 2n
   * operations, the growth rate is still linear. For example:
   * </p>
   * <pre>
   * - n = 1,000:    2n = 2,000 operations vs n = 1,000 operations (2x difference)
   * - n = 1,000,000: 2n = 2,000,000 operations vs n = 1,000,000 operations (2x difference)
   *
   * The ratio remains constant (2x), not exponential, so we say both are O(n).
   * </pre>
   *
   * <p>
   * <b>Visual Example (n = 3):</b>
   * </p>
   * <pre>
   * First Loop:   prints 0, 1, 2     (3 iterations)
   * Second Loop:  prints 0, 1, 2     (3 iterations)
   * Total Output: 6 print operations  (2n = 2×3 = 6)
   * Simplified:   O(n) not O(2n)
   * </pre>
   *
   * @param n The input size determining how many items are printed in each loop. Both loops iterate
   *          exactly n times, making the total operations 2n. This parameter directly influences
   *          the algorithm's execution time linearly.
   */
  public static void printItems(int n) {
    /* First loop: Executes n times, printing values from 0 to n-1.
       Time Complexity: O(n) - Linear, proportional to input size */
    for (int i = 0; i < n; i++) {
      System.out.println(i);
    }

    /* Second loop: Also executes n times, printing values from 0 to n-1.
       Time Complexity: O(n) - Linear, proportional to input size
       Even though we have two sequential loops, the combined O(n + n) simplifies to O(n)
       because constant factors are dropped in Big O analysis. */
    for (int r = 0; r < n; r++) {
      System.out.println(r);
    }
  }

  /**
   * <h2>Java main method</h2>
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    printItems(3);
  }
}
