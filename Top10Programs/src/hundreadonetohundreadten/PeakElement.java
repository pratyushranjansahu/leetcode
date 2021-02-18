package hundreadonetohundreadten;
//https://www.youtube.com/watch?v=uZkyxzn3RzA
public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// BRUTE FORCE CODE
	 
	 public int findPeakElement1(int[] nums) {
	        
	        if(nums.length==1)return 0;
	        
	        for(int i=0;i<nums.length;i++){
	            if(i==0 && nums[0]>nums[1])return 0;
	            if(i==nums.length-1 && nums[i]>nums[i-1])return nums.length-1;
	            
	            if(nums[i]>nums[i+1] && nums[i]>nums[i-1])return i;
	        }
	        
	        return -1;
	    }
	
	//optimal
public static int findPeakElement(int[] nums) {
        
        if(nums.length==1)return 0;
        
        int low = 0 , high = nums.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))return mid;
            
            if(nums[mid]>nums[mid+1]){
                high = mid;
            }else{ 
                low = mid+1;
            }
        }
        
        return high;
    }

}
