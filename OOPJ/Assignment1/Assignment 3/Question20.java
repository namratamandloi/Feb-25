 class MatrixTranspose {

    
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] transposedMatrix = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        
        return transposedMatrix;
	}
  
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Print the original matrix
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Get the transpose of the matrix
        int[][] transposedMatrix = transpose(matrix);

        // Print the transposed matrix
        System.out.println("Transposed Matrix:");
        printMatrix(transposedMatrix);
    }
}