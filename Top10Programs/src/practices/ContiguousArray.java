package practices;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int longestCount = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] == 1 ? 1 : -1;
			if (sum == 0) {
				if (longestCount < i + 1)
					longestCount = i + 1;
			} else if (map.containsKey(sum)) {
				if (longestCount < i - map.get(sum))
					longestCount = i - map.get(sum);

			} else {
				map.put(sum, i);
			}
		}

		return longestCount;
	}

}
