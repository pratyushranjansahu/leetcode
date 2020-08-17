package practices;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(prod(nums));

	}
	
	private static int[] prod(int[] arr) {
		int[] result=new int[arr.length];
		result[0]=1;
		int leftProduct=1;
		for(int i=0;i<arr.length;i++) {
			result[i]=leftProduct;
			leftProduct*=arr[i];
		}
		
		int rightProduct=1;
		for(int i=arr.length-1;i>=0;i--) {
			result[i]*=rightProduct;
			rightProduct*=arr[i];
		}
		return result;
	}

}
