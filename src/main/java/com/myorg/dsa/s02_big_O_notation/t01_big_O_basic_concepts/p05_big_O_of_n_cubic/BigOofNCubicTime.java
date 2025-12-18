package com.myorg.dsa.s02_big_O_notation.t01_big_O_basic_concepts.p05_big_O_of_n_cubic;

/**
 * <h1>BigOofNCubicTime class : Demonstrates Big O : O(n^3)</h1>
 */
public class BigOofNCubicTime {

  /**
   * <h2>Multiplies two 2D matrices using a cubic time complexity algorithm</h2>
   *
   * <p>
   * This method performs standard matrix multiplication between two 2D matrices {@code matrixA} and
   * {@code matrixB}. It uses three nested loops to compute each element of the resulting matrix,
   * resulting in a time complexity of
   * <b>O(n³)</b> for square matrices.
   * </p>
   *
   * <p>
   * For each element {@code matrixC[i][j]}, the method computes the dot product of row {@code i}
   * from {@code matrixA} and column {@code j} from {@code matrixB}:
   * </p>
   *
   * <pre>
   * matrixC[i][j] = Σ (matrixA[i][k] × matrixB[k][j])
   * </pre>
   *
   * <p>
   * where {@code k} iterates over the shared dimension of the two matrices.
   * </p>
   *
   * <b>Time Complexity:</b>
   * <ul>
   *   <li>Three nested loops → O(n³) for n × n matrices</li>
   *   <li>Outer loop → rows of matrixA</li>
   *   <li>Middle loop → columns of matrixB</li>
   *   <li>Inner loop → shared dimension (columns of matrixA / rows of matrixB)</li>
   * </ul>
   *
   * <b>Example (3×3 matrices):</b>
   * <pre>
   * matrixA           matrixB           matrixC
   * 1  2  3           1  2  3            30  36  42
   * 4  5  6     ×     4  5  6      =     66  81  96
   * 7  8  9           7  8  9           102 126  150
   * </pre>
   *
   * <p>
   * The total number of multiplication operations performed is
   * {@code rows × columns × sharedDimension}.
   * </p>
   *
   * <b>Assumptions:</b>
   * <ul>
   *   <li>Both input matrices are non-null and properly initialized.</li>
   *   <li>The number of columns in {@code matrixA} equals the number of rows in {@code matrixB}.</li>
   * </ul>
   *
   * @param matrixA The first input matrix (rows × shared dimension)
   * @param matrixB The second input matrix (shared dimension × columns)
   * @return A new matrix representing the product of {@code matrixA} and {@code matrixB}
   * @throws IllegalArgumentException if the matrices cannot be multiplied due to incompatible
   *                                  dimensions
   */
  public static int[][] multiply2DMatrices(int[][] matrixA, int[][] matrixB) {
    // Number of rows in matrixA
    int rows = matrixA.length;

    // Number of columns in matrixB
    int cols = matrixB[0].length;

    // Initialize the result matrix with appropriate dimensions
    int[][] matrixC = new int[rows][cols];

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixB[0].length; j++) {
        for (int k = 0; k < matrixB.length; k++) {
          matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
        }
      }
    }
    return matrixC;
  }

  /**
   * Helper method which accepts a 2D matrix and prints it to the console.
   */
  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      for (int val : row) {
        /* %4d means print integer with width of 4 characters for better alignment. */
        System.out.printf("%4d ", val);
      }
      System.out.println();
    }
  }

  /**
   * <h2>Java main method</h2>
   *
   * @param args String array arguments.
   */
  public static void main(String[] args) {
    int[][] matrixA = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    int[][] matrixB = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    printMatrix(multiply2DMatrices(matrixA, matrixB));
    System.out.println();
    
    int[][] matrixD = {
        {1, 2, 3},
        {7, 8, 9}
    };

    int[][] matrixE = {
        {1, 2, 3},
        {7, 8, 9}
    };

    printMatrix(multiply2DMatrices(matrixD, matrixE));
  }
}
