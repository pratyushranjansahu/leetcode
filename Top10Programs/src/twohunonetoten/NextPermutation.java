package twohunonetoten;
/*
    https://leetcode.com/problems/next-permutation/
    https://www.youtube.com/watch?v=6ENl3OwwxLg
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);//[1,3,2]
    }
    public static void nextPermutation(int[] nums) {
        int k = nums.length-2;
        //while(k>=0 && nums[k]>=nums[k+1])k--;
        for(int i = nums.length-1;i>0;i--){
            if(nums[i] <= nums[i-1]){
                k--;
            }else {
                break;
            }
        }

        //CASE 1
        if(k==-1){
            reverseArray(0,nums.length-1,nums);
            return;
        }

        //CASE 2
        for(int i = nums.length-1;i>k;i--){
            if(nums[i]>nums[k]){//2
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                break;
            }
        }
        reverseArray(k+1,nums.length-1,nums);
        System.out.println("Hai");
    }

    static void reverseArray(int i,int j,int[] nums){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }
}
