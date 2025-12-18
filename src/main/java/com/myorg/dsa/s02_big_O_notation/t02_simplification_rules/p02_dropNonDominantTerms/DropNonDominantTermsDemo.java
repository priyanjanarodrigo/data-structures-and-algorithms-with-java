package com.myorg.dsa.s02_big_O_notation.t02_simplification_rules.p02_dropNonDominantTerms;

/**
 * <h1>DropNonDominantTermsDemo class : Demonstrates Big O Simplification Rule - Drop Non-Dominant
 * Terms</h1>
 */
public class DropNonDominantTermsDemo {

  /**
   * <h2>Big O Simplification: Drop Non-Dominant Terms Rule</h2>
   * <hr>
   * <p>
   * Demonstrates the "Drop Non-Dominant Terms" simplification rule in Big O notation analysis. This
   * method contains nested loops (O(n²)) followed by a simple loop (O(n)), illustrating how less
   * significant operations are dropped when a dominant term exists.
   * </p>
   *
   * <p>
   * <b>Algorithm Breakdown:</b>
   * </p>
   * <ul>
   *   <li><b>Nested loops:</b> Executes n × n times → O(n²) operations (DOMINANT)</li>
   *   <li><b>Simple loop:</b> Executes n times → O(n) operations (NON-DOMINANT)</li>
   *   <li><b>Total operations:</b> n² + n operations</li>
   * </ul>
   *
   * <p>
   * <b>Big O Simplification Process:</b>
   * </p>
   * <pre>
   * Step 1: Count total operations
   *         O(n² + n)
   *
   * Step 2: Identify dominant vs non-dominant terms
   *         n² is DOMINANT (grows much faster than n)
   *         n is NON-DOMINANT (becomes insignificant at scale)
   *
   * Step 3: Drop non-dominant terms
   *         O(n² + n) ====DROP NON-DOMINANT====> O(n²)
   *
   * Step 4: Simplified Big O notation
   *         Final Complexity = O(n²) Quadratic Time
   * </pre>
   *
   * <p>
   * <b>Why Drop Non-Dominant Terms?</b><br>
   * As n grows large, the dominant term completely overshadows non-dominant terms. The ratio of
   * n² to n becomes increasingly disproportionate, making the linear n negligible:
   * </p>
   * <pre>
   * - n = 10:     n² = 100,    n = 10      (n² is 10x larger)
   * - n = 100:    n² = 10,000, n = 100     (n² is 100x larger)
   * - n = 1,000:  n² = 1,000,000, n = 1,000 (n² is 1,000x larger)
   *
   * At scale, the linear term becomes irrelevant to growth analysis.
   * </pre>
   *
   * <p>
   * <b>Visual Example (n = 3):</b>
   * </p>
   * <pre>
   * Nested Loops Output:
   *   0 --- 0  (i=0, j=0)
   *   0 --- 1  (i=0, j=1)
   *   0 --- 2  (i=0, j=2)
   *   1 --- 0  (i=1, j=0)
   *   1 --- 1  (i=1, j=1)
   *   1 --- 2  (i=1, j=2)
   *   2 --- 0  (i=2, j=0)
   *   2 --- 1  (i=2, j=1)
   *   2 --- 2  (i=2, j=2)
   * [Total: 9 operations = n² = 3²]
   *
   * Simple Loop Output:
   *   0, 1, 2
   * [Total: 3 operations = n = 3]
   *
   * Combined: n² + n = 9 + 3 = 12 operations
   * Simplified: O(n²) - The quadratic term dominates
   * </pre>
   *
   * @param n The input size determining iterations for all loops. The nested loops execute n² times
   *          (dominant), while the final loop executes n times (non-dominant). The quadratic growth
   *          from nested loops overwhelmingly determines the overall time complexity.
   */
  public static void printItems(int n) {
    /* Nested loops: Executes n × n = n² times total
       Time Complexity: O(n²) - Quadratic
       This is the DOMINANT term that overshadows the simple loop below.
       For each of the n iterations of the outer loop, the inner loop runs n times. */
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println(i + " --- " + j);
      }
    }

    System.out.println();

    /* Simple loop: Executes n times
       Time Complexity: O(n) - Linear
       This is a NON-DOMINANT term. When combined with O(n²), the linear O(n) becomes negligible
       and is dropped during Big O simplification: O(n² + n) = O(n²)
       The quadratic growth of nested loops dominates the linear growth of this loop. */
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
