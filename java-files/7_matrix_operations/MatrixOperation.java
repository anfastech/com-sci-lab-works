
/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * MatrixOperation
 * -------------------------
 * +PrintMatrix(matrix : int[][]) : void
 * +calculateTrace(matrix : int[][]) : int
 * +calculateTranspose(matrix : int[][]) : int[][]
 * +main(args : String[]) : void
 * -------------------------
 */

public class MatrixOperation {
    public static void PrintMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    /**
     * Calculates the trace of a square matrix.
     * 
     * The trace of a matrix is the sum of its diagonal elements (elements where row index equals column index).
     * 
     * @param matrix a 2D integer array representing the matrix
     * @return the sum of diagonal elements if the matrix is square, or -1 if the matrix is not square
     * @throws ArrayIndexOutOfBoundsException if the matrix is null or empty
     * 
     * @note Trace is only defined for square matrices (where number of rows equals number of columns).
     *       This method returns -1 and prints an error message if a non-square matrix is provided.
     */
    public static int calculateTrace(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Trace is only defined for square matrices.");
            return -1;
        }

        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int[][] calculateTranspose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        PrintMatrix(matrix);

        int[][] transpose = calculateTranspose(matrix);
        System.out.println("Transpose:");
        PrintMatrix(transpose);
    }
}
