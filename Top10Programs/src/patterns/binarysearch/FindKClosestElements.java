package patterns.binarysearch;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/find-k-closest-elements/
    https://www.youtube.com/watch?v=IRtv7pdp8hQ
    https://www.youtube.com/watch?v=6AackEaa0Qs&t=614s
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        System.out.println(findClosestElements(arr, k , x));//[1, 2, 3, 4]
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
