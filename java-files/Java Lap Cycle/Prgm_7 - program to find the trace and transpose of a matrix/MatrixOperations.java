/**
 * MatrixOperations.java
 * This program demonstrates how to find the trace and transpose 
 * of a hardcoded square matrix using basic Java array manipulation.
 */
public class MatrixOperations {

    /**
     * Prints a 2D integer array (matrix) to the console in a readable format.
     *  param matrix The 2D array to print.
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[0].length; j++) {
                // Print the element followed by a space
                System.out.printf("%4d", matrix[i][j]); 
            }
            System.out.println(" |");
        }
    }

    /**
     * Calculates the Trace of a square matrix.
     * The trace is the sum of the elements on the main diagonal (where row index == column index).
     * @param matrix The square matrix.
     * @return The trace (an integer sum).
     */


    public static int calculateTrace(int[][] matrix) {
        // The trace can only be calculated for square matrices (where number of rows = number of columns)
        if (matrix.length != matrix[0].length) {
            System.out.println("Error: Trace requires a square matrix.");
            return 0;
        }

        int trace = 0;
        
        // Loop along the main diagonal (i == j)
        for (int i = 0; i < matrix.length; i++) {
            // Add the element at (i, i) to the trace
            trace += matrix[i][i]; 
        }
        return trace;
    }

    /**
     * Calculates the Transpose of a matrix.
     * The transpose is a new matrix where the rows and columns are flipped.
     * Element at (i, j) in the original matrix moves to (j, i) in the transpose.
     * @param originalMatrix The input matrix.
     * @return The new transposed matrix.
     */

     
    public static int[][] calculateTranspose(int[][] originalMatrix) {
        int rows = originalMatrix.length;    // Number of rows in the original matrix
        int cols = originalMatrix[0].length; // Number of columns in the original matrix
        
        // The transposed matrix will have 'cols' rows and 'rows' columns
        int[][] transposedMatrix = new int[cols][rows];

        // Loop through the rows of the original matrix
        for (int i = 0; i < rows; i++) {
            // Loop through the columns of the original matrix
            for (int j = 0; j < cols; j++) {
                // The core operation: copy element from (i, j) to (j, i)
                transposedMatrix[j][i] = originalMatrix[i][j];
            }
        }
        
        return transposedMatrix;
    }

    public static void main(String[] args) {
        // Define the sample matrix (3x3 square matrix)
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("--- Original Matrix A ---");
        printMatrix(matrixA);

        // 1. Calculate and Print the Trace
        int traceResult = calculateTrace(matrixA);
        System.out.println("\n------------------------------------");
        System.out.println("Trace of Matrix A (Sum of Diagonal): " + traceResult);
        System.out.println("------------------------------------");
        
        // 2. Calculate and Print the Transpose
        int[][] matrixATranspose = calculateTranspose(matrixA);
        
        System.out.println("\n--- Transposed Matrix A^T ---");
        printMatrix(matrixATranspose);
    }
}