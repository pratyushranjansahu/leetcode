package practiceinorder.p_81;

import java.util.HashMap;
import java.util.Map;

public class CountElements {

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 3 };
		int[] arr = { 1, 1, 2 };
		System.out.println(countElement(arr));
	}

	private static int countElement(int[] arr) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
			if (map.containsKey(entries.getKey() + 1)) {
				result += entries.getValue();
			}
		}
		return result;
	}

}
