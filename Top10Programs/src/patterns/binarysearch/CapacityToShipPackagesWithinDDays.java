package patterns.binarysearch;
/*
    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    https://www.youtube.com/watch?v=1w4-rZhP7BM&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=24
 */
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days)); //15
    }
    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int val : weights) {
            sum += val;
            max = Math.max(val,max);
        }
        int lo = max;
        int hi = sum;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (isPossible(weights, mid, days)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid +1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int[] a, int mid, int days) {
        int d = 1;
        int sum = 0;
        for (int i = 0; i<a.length; i++) {
            sum += a[i];
            if (sum > mid) {
                d++;
                sum = a[i];
            }
        }
        return d <= days;
    }
}
