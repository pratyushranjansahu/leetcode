package patterns.arrays;
/*
 * https://leetcode.com/problems/set-matrix-zeroes/
 * https://www.youtube.com/watch?v=zgaOU5aInOc
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);//[[1,0,1],[0,0,0],[1,0,1]]
    }
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean row = false, col = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col = true;
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                row = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
