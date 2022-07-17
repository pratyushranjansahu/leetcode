package patterns.twopointer;
/*
    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    https://www.youtube.com/watch?v=QHKrz0c7E3U
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(numbers, target);
        for (int n : res) {
            System.out.print(n+" ");//[1,2]
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0 , end = numbers.length-1;
        while(start<end){
            if(numbers[start]+numbers[end]>target){
                end--;
            }else if(numbers[start]+numbers[end]<target){
                start++;
            }else{
                return new int[]{start+1,end+1};
            }
        }
        return new int[]{};
    }
}
