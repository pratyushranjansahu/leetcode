package patterns.binarysearch;
/*
    https://leetcode.com/problems/find-peak-element/
    https://www.youtube.com/watch?v=uZkyxzn3RzA
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums)); //2
    }
    public static int findPeakElement(int[] nums) {
        if(nums.length==1)return 0;

        int low = 0 , high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))return mid;

            if(nums[mid]>nums[mid+1]){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return high;
    }
}
