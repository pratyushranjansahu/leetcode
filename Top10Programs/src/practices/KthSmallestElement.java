package practices;

public class KthSmallestElement {

	public static void main(String[] args) {
		int k=3;
		//int[] arr= {1,2,4,5,6,7,3,8};
		//int[] arr= {89,11,15,30,60,120,7,92,26};
		//System.out.println(getHighest(arr,3));
		int[] arr= {2,1,0,1,1,0,1,0,1,0,2,2,2};
		/*for(int a: sort012(arr, arr.length)) {
			System.out.println(a);
		}*/
		
		for(int a: sortArray1(arr)) {
			System.out.println(a);
		}
		
	}
	
	private static  int getHighest(int[] a,int k) {
	
	/*	for(int i=0;i<a.length-1;i++) {
		  for(int j=i+1;i<a.length;j++) {
			  if(a[i]>a[j]) {
				  int t=a[j];
				  a[j]=a[i];
				  a[i]=t;
			  }
		  }	
			
		}*/
		
		int max1=Integer.MIN_VALUE;
		int max2=Integer.MIN_VALUE;
		int c=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>max2) {
				max1=max2;
				max2=a[i];
			}
		}
		
		return -1;
	}
	
	private static int[] sortArray(int[] arr) {
		int k=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				int t=arr[i];
				arr[i]=arr[k];
				arr[k]=t;
				k++;
				
			}
		}
		
		return arr;
	}
	
	private static int[] sortArray1(int[] arr) {
		int l=0;
		int m=0;
		int r=arr.length-1;
		//int i=0;
		while(m<=r) {
			switch (arr[m]) {
			case 0:
				int t=arr[m];
				
				arr[m]=arr[l];
				arr[l]=t;
				l++;m++;
			/*	int t=arr[m];
				arr[m]=arr[l];
				arr[l]=t;
				l++;
				m++;*/
				break;
			case 1:
				m++;
				break;
			case 2:
				int te=arr[m];
				arr[m]=arr[r];
				arr[r]=te;
				r--;
				/* int  temp = arr[m]; 
	                arr[m] = arr[r]; 
	                arr[r] = temp; 
	                r--; */
				
				break;
				default:
					break;

			}
		}
		return arr;
		
	}
	
	 static int[] sort012(int a[], int arr_size) 
	    { 
	        int lo = 0; 
	        int hi = arr_size - 1; 
	        int mid = 0, temp = 0; 
	        while (mid <= hi) { 
	            switch (a[mid]) { 
	            case 0: { 
	                temp = a[lo]; 
	                a[lo] = a[mid]; 
	                a[mid] = temp; 
	                lo++; 
	                mid++; 
	                break; 
	            } 
	            case 1: 
	                mid++; 
	                break; 
	            case 2: { 
	                temp = a[mid]; 
	                a[mid] = a[hi]; 
	                a[hi] = temp; 
	                hi--; 
	                break; 
	            } 
	            } 
	        } 
	        return a;
	    } 

}
