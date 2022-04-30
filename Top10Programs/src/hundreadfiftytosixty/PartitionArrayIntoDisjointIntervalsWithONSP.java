package hundreadfiftytosixty;
/*
    https://leetcode.com/problems/partition-array-into-disjoint-intervals/submissions/
    leet code has a difference for "if (leftMax <= rightMin[i+1])" condition
    https://www.youtube.com/watch?v=FRG2YlZdmPE&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=11

    space complexity in 0(N)
 */
public class PartitionArrayIntoDisjointIntervalsWithONSP {
    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(partitionDisjointWithOoneSpace(arr));//1
    }
    public static int partitionDisjointLeetCode(int[] nums) {
        int n = nums.length;
        //Make a right min array
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        for (int i = n-1; i >=0 ; i--) {
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }
        //Maintain left max and figure out the partition index
        int leftMax = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (leftMax <= rightMin[i+1]) {
                ans = i;
                break;
            }
        }
        return ans+1;
    }
    private static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        //Make a right min array
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        for (int i = n-1; i >=0 ; i--) {
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }
        //Maintain left max and figure out the partition index
        int leftMax = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (leftMax < rightMin[i+1]) {
                ans = i;
                break;
            }
        }
        return ans+1;
    }
    private static int partitionDisjointWithOoneSpace(int[] nums) {
        int leftMax = nums[0];
        int greater = nums[0];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > greater) {
                greater = nums[i];
            }else if (nums[i] < leftMax) {
                leftMax = greater;
                ans = i;
            }
        }
        return ans+1;
    }
}
