package twohunonetoten;
/*
    https://www.geeksforgeeks.org/allocate-minimum-number-pages/
    https://www.youtube.com/watch?v=okP-e2VpI_g&t=3243s
    https://www.youtube.com/watch?v=gYmWHvRHu-s&t=66s
 */
public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {

        int[] arr = {250, 74, 159, 181, 23, 45, 129, 174};
        int m = 6;
        System.out.println(minPages(arr, m));

    }
    private static int minPages(int[] arr, int m) {
        int sum = 0;
        int max = 0;
        for (int val : arr) {
            sum += val;
            max = Math.max(max, val);
        }
        int lo = max;
        int hi = sum;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(arr, mid, m)) {
                ans = mid;
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int[] arr, int mid, int m) {
        int st = 1;
        int sum = 0;
        for (int i = 0; i <arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                st++;
                sum = arr[i];
            }
        }
        return st <= m;
    }
}
