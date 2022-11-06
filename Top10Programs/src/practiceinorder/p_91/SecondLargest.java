package practiceinorder.p_91;

public class SecondLargest {

	public static void main(String[] args) {
		int[] arr= {2,4,1,5};
		System.out.println(getsecondLargest(arr));

	}
	
	static int getsecondLargest(int[] arr){
		int max1=Integer.MIN_VALUE;
		int max2=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
		if(arr[i]>max1){
		    max2=max1;
		    max1=arr[i];
		}else if(arr[i]>max2){
		max2=arr[i];
		}
		}
		return max2;
		}


}
