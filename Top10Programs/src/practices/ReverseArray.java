package practices;

public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 6, 8, 9 };
		int[] a = reverseArray(arr);
		for (int n : a) {
			System.out.print(n + " ");
		}
	}

	private static int[] reverseArray(int[] arr) {
		int n = arr.length;
		int l = 0;
		int r = n - 1;
		while (l < r) {
			int tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			l++;
			r--;
		}
		return arr;

	}

}
