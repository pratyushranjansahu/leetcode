package hundreadfiftytosixty;
/*
    https://leetcode.com/problems/max-chunks-to-make-sorted-ii/submissions/
    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/max-chunks-to-make-array-sorted-2/ojquestion
    https://www.youtube.com/watch?v=GxTo3agdnjs
 */
public class MaxChunksToMakeArraySortedII {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(maxChunkSortedArray(arr));//1
    }
    private static int maxChunkSortedArray(int[] arr) {
        int count = 0;
        int n = arr.length;
        //generate Right Min
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        for (int i = n-1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], arr[i]);
        }
        //iterate the array & manage the left max as well as chuck count
        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            if (leftMax <= rightMin[i+1]) {
                count++;
            }
        }
        return count;
    }
}
