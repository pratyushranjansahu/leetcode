package practiceinorder.p_11;

import java.util.HashMap;
import java.util.Map;
/*
	https://leetcode.com/problems/subarray-sum-equals-k/submissions/
	https://www.youtube.com/watch?v=MHocw0bP1rA
	https://github.com/luckykumardev/leetcode-solution/blob/master/Subarray%20Sum%20Equals%20K.java
 */
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		//int[] nums = { 1, 2, 1, 2, 1 };
		//int k = 3;
		int[] nums = { 3, 4, 7, 2, -3,1,4,2 };
		int k = 7;
		System.out.println(subarraySum(nums, k));//4
	}

	private static int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

}
