package seventyonetoeighty;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3, 4, 2, 6, 2, 6, 7, 2 };
		int val = 2;
		System.out.println("Nums length is : " + nums.length);
		System.out.println(removeElement(nums, val));
	}

	private static int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val)
				nums[i++] = nums[j];

		}
		return i;
	}

}
