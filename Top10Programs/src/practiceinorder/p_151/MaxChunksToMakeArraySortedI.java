package practiceinorder.p_151;
/*
    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/max-chunks-to-make-array-sorted/ojquestion
    https://www.youtube.com/watch?v=XZueXHOhO5E
 */
public class MaxChunksToMakeArraySortedI {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,0};
        System.out.println(maxChunk(arr)); // 1
    }
    private static int maxChunk(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) {
                count++;
            }
        }
        return count;
    }
}
