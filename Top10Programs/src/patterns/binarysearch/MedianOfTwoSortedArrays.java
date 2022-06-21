package patterns.binarysearch;
/*
    https://leetcode.com/problems/median-of-two-sorted-arrays/
    https://www.youtube.com/watch?v=jDJuW7tSxio&t=3458s
    https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));//2.0
    }
    public static double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            int[] t = a;
            a = b;
            b =t;
        }
        int lo = 0;
        int hi = a.length;
        int te = a.length + b.length;
        while (lo <= hi) {
            int aleft = (lo + hi) / 2;
            int bleft = (te + 1) / 2 - aleft;

            int alm1 = aleft == 0 ? Integer.MIN_VALUE : a[aleft - 1];
            int al = aleft == a.length ? Integer.MAX_VALUE : a[aleft];
            int blm1 = bleft == 0 ? Integer.MIN_VALUE : b[bleft - 1];
            int bl = bleft == b.length ? Integer.MAX_VALUE : b[bleft];

            if (alm1 <= bl && blm1 <= al) {
                double median = 0.0;
                if (te % 2 == 0) {
                    int lmax = Math.max(alm1, blm1);
                    int rmin = Math.min(al, bl);
                    median = (lmax+rmin)/ 2.0;
                }else {
                    int lmax = Math.max(alm1, blm1);
                    median = lmax;
                }
                return median;
            } else if (alm1 > bl) {
                hi = aleft - 1;
            }else if (blm1 > al) {
                lo = aleft + 1;
            }
        }
        return 0;
    }

}
