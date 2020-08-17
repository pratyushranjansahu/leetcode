package fiftyonetosixty;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 1 };
		int k = 3;
		System.out.println(subarraySum(nums, k));
	}

	private static int subarraySum(int[] nums, int k) {
		if (nums.length == 0)
			return 0;
		int count = 0;
		int currentSum = 0;
		//currentSum and Count
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];
			if (currentSum == k)
				count++;
			if (map.containsKey(currentSum - k)) {
				count += map.get(currentSum - k);
			}
			map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

		}

		return count;
	}

}
