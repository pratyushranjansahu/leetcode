package hundreadtwintyonetothirty;

//https://www.youtube.com/watch?v=W-UalzYVEiQ
public class WoodCuttingMadeEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solve(int[] A, int B) {

		int h = 0;
		int max = 0;
		int min = 0;
		int ans = 0;

		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}

		while (min <= max) {
			int mid = min + (max - min) / 2;
			long wood = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] - mid > 0) {
					wood = wood + A[j] - mid;
				}
			}
			if (wood >= (long) B) {
				min = mid + 1;
				// 0 5 10 15
				ans = Math.max(ans, mid);// 15
			} else {
				max = mid - 1;
			}
		}
		return ans;
	}

}
