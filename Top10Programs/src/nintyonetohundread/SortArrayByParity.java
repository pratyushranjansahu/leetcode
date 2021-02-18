package nintyonetohundread;

public class SortArrayByParity {

	public static void main(String[] args) {
		int[] arr= {3,1,2,4};
		//sortArrayByParity(A);
		//int[] arr= {0,0,0,0,1,1,1,1,0,0,0,0};
		arr=moveZero(arr);
		for(int c : arr) {
			System.out.println(c+" ");
		}
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
	private static int[] moveZero(int[] arr) {
		int k=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				int t=arr[i];
				arr[i]=arr[k];
				arr[k]=t;
				k++;
			}
		}
		
		return arr;
	}

}
