package practiceinorder.p_171;
/*
    https://www.interviewbit.com/problems/allocate-books/
    https://www.youtube.com/watch?v=okP-e2VpI_g&t=3243s
    https://www.youtube.com/watch?v=gYmWHvRHu-s&t=66s
 */
public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {

        int[] arr = {12, 34, 67, 90};
        int m = 2;
        System.out.println(minPages(arr, m));//113

    }
    private static int minPages(int[] arr, int m) {
        int sum = 0;
        int max = 0;
        int n = arr.length;
        if (n < m)
            return -1;
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
