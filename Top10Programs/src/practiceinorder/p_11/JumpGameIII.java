package practiceinorder.p_11;

import java.util.HashSet;
import java.util.Set;
/*
   Youtube : https://www.youtube.com/watch?v=TsRyidwuNF8&t=456s
  Leetcode 1306
 */
public class JumpGameIII {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }
    private static boolean canReach(int[] arr, int start) {
        Set<Integer> set = new HashSet<>();
        return isPossible(arr, start, set);
    }

    private static boolean isPossible(int[] arr, int start, Set<Integer> set) {
        if (set.contains(start) || start < 0 || start >= arr.length) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        set.add(start);
        return isPossible(arr, start + arr[start], set) || isPossible(arr, start - arr[start], set);
    }
}
