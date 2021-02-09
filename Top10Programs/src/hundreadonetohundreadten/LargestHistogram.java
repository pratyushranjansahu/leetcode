package hundreadonetohundreadten;

import java.util.Stack;

public class LargestHistogram {

	public static void main(String[] args) {
		//int[] arr = { 2, 1, 5, 6, 2, 3 };
		int[] arr = { 2, 1, 5, 6, 5, 3 };
		// int[] arr= {5,6,7};
		// int[] arr= {1,1};
		System.out.println(getMaxArea(arr));

	}

	static int getMaxArea(int[] heights) {
		int maxArea = 0;
		if (heights.length == 0)
			return 0;
		if (heights.length == 1)
			return heights[0];
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		for (int i = 1; i < heights.length; i++) {
			int current = heights[i];
			if (current >= heights[stack.peek()]) {
				stack.add(i);
			} else {
				while (!stack.isEmpty() && current < heights[stack.peek()]) {
					int temp = heights[stack.pop()];
					if (stack.isEmpty()) {
						maxArea = Math.max(maxArea, temp * i);
					} else {
						maxArea = Math.max(maxArea, temp * (i - stack.peek() - 1));
					}

				}
				stack.add(i);
			}

		}
		if (!stack.isEmpty()) {
			int i = heights.length;
			while (!stack.isEmpty()) {
				int temp = heights[stack.pop()];
				if (stack.isEmpty()) {
					maxArea = Math.max(maxArea, temp * i);
				} else {
					maxArea = Math.max(maxArea, temp * (i - stack.peek() - 1));
				}

			}
		}

		return maxArea;
	}

}
