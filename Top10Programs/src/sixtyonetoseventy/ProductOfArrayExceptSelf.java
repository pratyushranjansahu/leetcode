package sixtyonetoseventy;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		productExceptSelf(nums);
	}

	private static int[] productExceptSelf(int[] nums) {
		int[] result=new int[nums.length];
		int product=1;
		result[0]=1;
		int n=nums.length;
		for(int i=0;i<n;i++) {
			result[i]=product;
			product*=nums[i];
			
		}
		int rightProduct=1;
		for(int i=n-1;i>=0;i--) {
			result[i]*=rightProduct;
			rightProduct*=nums[i];
		}
		return result;
	}

}
