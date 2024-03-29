package patterns.binarysearch;
/*
    https://leetcode.com/problems/peak-index-in-a-mountain-array/
    https://www.youtube.com/watch?v=LHfS7bA6dCA
 */
public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(peakIndexInMountainArray(arr));//1
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
