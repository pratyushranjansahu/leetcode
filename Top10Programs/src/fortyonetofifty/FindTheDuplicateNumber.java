package fortyonetofifty;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		int[] nums= {1,3,4,2,2};
		System.out.println(findDuplicate(nums));
	}
	
	private static int findDuplicate(int[] nums) {
		int idx=0;
		int currentMax=0;
		int n=nums.length;
		for(int i=0;i<nums.length;i++) {
			int id=nums[i]%n;
			nums[id]+=n;
		}
		
		for(int i=0;i<n;i++) {
			if(nums[i]>currentMax) {
				currentMax=nums[i];
				idx=i;
			}
			  nums[i] %= n;
		}
		
		return idx;
	}

}
