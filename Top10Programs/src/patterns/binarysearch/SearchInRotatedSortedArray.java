package patterns.binarysearch;
/*
    https://leetcode.com/problems/search-in-rotated-sorted-array/
    https://www.youtube.com/watch?v=1uu3g_uu8O0&t=794s
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target)); // 4
    }
    public static int search(int[] nums, int target) {
        int l=0, r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[l] <= nums[mid]){
                if((nums[l] <= target) && (nums[mid] > target))
                    r = mid-1;
                else
                    l = mid + 1;
            } else {
                if((nums[mid] < target) && (nums[r] >= target))
                    l = mid + 1;
                else
                    r = mid-1;
            }
        }
        return -1;
    }
}
