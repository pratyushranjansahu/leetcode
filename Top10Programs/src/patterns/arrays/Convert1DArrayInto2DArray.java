package patterns.arrays;
/*
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 * https://www.youtube.com/watch?v=h5MUrXHQGs4
 */
public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        int[] original = {1,2,3,4};
        int m = 2;
        int n = 2;
        int[][] res = construct2DArray(original, m, n);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");//{{1,2},{3,4}}
            }
            System.out.println();
        }
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int n1 = original.length;
        if (n1 != m * n) {
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        for (int idx = 0; idx < original.length; idx++) {
            int newRow = idx / n;
            int newColumn = idx % n;
            res[newRow][newColumn] = original[idx];
        }
        return res;
    }
}
