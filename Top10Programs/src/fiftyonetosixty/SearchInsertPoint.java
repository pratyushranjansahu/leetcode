package fiftyonetosixty;

public class SearchInsertPoint {

	public static void main(String[] args) {
		int[] nums={1,3,5,6};
		int target= 4;
		System.out.println(searchInsert(nums, target));
	}
	private static int searchInsert(int[] nums, int target) {
		int l=0,r=nums.length-1;
		
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(nums[mid]<target)
				l=mid+1;
			else if(nums[mid]>target)
				r=mid-1;
			else
				return mid;
				
		}
		return l;
	}

}
