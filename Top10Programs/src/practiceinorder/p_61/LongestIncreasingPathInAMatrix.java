package practiceinorder.p_61;
/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * https://www.youtube.com/watch?v=wv_GA9077Dc
 */
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));//4
    }
    private static int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(max, lip(matrix, i, j, dp));
            }
        }
        return max;
    }

    private static int lip(int[][] matrix, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int currentMax = 1;
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            currentMax = Math.max(currentMax, 1 + lip(matrix, i + 1, j, dp));
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            currentMax = Math.max(currentMax, 1 + lip(matrix, i, j + 1, dp));
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            currentMax = Math.max(currentMax, 1 + lip(matrix, i - 1, j, dp));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            currentMax = Math.max(currentMax, 1 + lip(matrix, i, j - 1, dp));
        }
        dp[i][j] = currentMax;
        return currentMax;
    }
}
