package seventyonetoeighty;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] a= {1,2,3,2,4};
		System.out.println(firstMissingPositive(a));
	}

	private static int firstMissingPositive(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			while (a[i] != i + 1) {
				if (a[i] <= 0 || a[i] >= n)
					break;
				if (a[i] == a[a[i] - 1])
					break;
				int temp = a[i];
				a[i] = a[temp - 1];
				a[temp - 1] = temp;
			}
		}

		for (int i = 0; i < n; ++i)
			if (a[i] != i + 1)
				return i + 1;

		return n + 1;
		/*int n = A.length;
		for (int i = 0; i < n; i++) {
    		while (A[i] != i + 1) {
    			if (A[i] <= 0 || A[i] >= n)
    				break;
 
                	if(A[i]==A[A[i]-1])
                    		break;
 
    			int temp = A[i];
    			A[i] = A[temp - 1];
    			A[temp - 1] = temp;
    		}
    	}
 
    	for (int i = 0; i < n; i++){
    		if (A[i] != i + 1){
    			return i + 1;
    		}
    	}	
 
    	return n + 1;*/
	}

}
