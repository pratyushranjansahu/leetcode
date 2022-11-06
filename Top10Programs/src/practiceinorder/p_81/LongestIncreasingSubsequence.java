package practiceinorder.p_81;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 5, 8, 7, 1, 9 };
		System.out.println(getLength(arr));
	}

	private static int getLength(int[] nums) {
		int maxCount = 0;
		int[] lsi=new int[nums.length];
		Arrays.fill(lsi, 1);
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]&& lsi[i]<=lsi[j]) {
					lsi[i]=1+lsi[j];
					if(maxCount<lsi[i])
					maxCount=lsi[i];
				}
			}
		}
		return maxCount;
	}

}
