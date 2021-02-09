package nintyonetohundread;

public class SortArrayByParity {

	public static void main(String[] args) {
		int[] A= {3,1,2,4};
		sortArrayByParity(A);
	}

	private static int[] sortArrayByParity(int[] A) {
		int l = 0, r = A.length - 1;
		while (l < r) {
			while (l < r && A[l] % 2 == 0)
				l++;
			while (l < r && A[r] % 2 == 1)
				r--;
			int tmp = A[l];
			A[l] = A[r];
			A[r] = tmp;
		}
		return A;
	}

}
