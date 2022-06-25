package patterns.binarysearch;
/*
    https://leetcode.com/problems/search-a-2d-matrix/
    https://www.youtube.com/watch?v=EmpwQ4C6WJs
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //int target = 3; //true
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13; //false
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = binarySearchRowSelect(matrix, target);
        if (r == -1)
            return false;
        boolean isFound = binarySearch(matrix, r, target);
        return isFound;
    }
    private static int binarySearchRowSelect (int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        int lc = matrix[0].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][lc]) {
                return mid;
            }else if (matrix[mid][0] < target) {
                lo = mid + 1;
            }else if (matrix[mid][0] > target) {
                hi = mid - 1;
            }
        }
        return -1;
    }
    private static boolean binarySearch (int[][] matrix, int row, int target) {
        int lo = 0;
        int hi = matrix[0].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }else if (matrix[row][mid] < target) {
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
