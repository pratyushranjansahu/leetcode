package hunseventytoeighty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * https://www.youtube.com/watch?v=tCVOQX3lWeI
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        //int[] arr = {1,3,-1,-3,5,3,6,7};
        //int k = 3;
        int[] arr = {2,3,1,4,5};
        int k = 4;
        maxSlidingWindowLeetcode(arr, k);//[3,3,5,5,6,7]
    }
    public static int[] maxSlidingWindowLeetcode(int[] a, int k) {
        List<Integer> res = new ArrayList();
        Stack<Integer> stack =new Stack();
        int[] nge = new int [a.length];
        stack.push(a.length-1);
        nge[a.length - 1] = a.length;
        for (int i = a.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] >= a[stack.peek()]) {
                    stack.pop();
            }
            nge[i] = stack.isEmpty() ? a.length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i <= a.length-k; i++) {
            int j = i;
            while (nge[j] < i+k) {
                j = nge[j];

            }
            res.add(a[j]);
        }
        int[] resArray = res.stream().mapToInt(i->i).toArray();
        return resArray;
    }
}
