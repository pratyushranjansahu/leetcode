package thirtyonetoforty;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr= {};
		int target=9;
		twoSum(arr,target);

	}
	
	private static int[] twoSum(int[] nums,int target) {
		int[] result=new int[2];
		Map<Integer,Integer> map=new HashMap();
		for(int i=0;i<nums.length;i++) {
			int complement=target-nums[i];
			if(map.containsKey(complement)) {
				int i0=map.get(complement);
				result[0]=i0;
				result[1]=i;
				return result;
			}else{
				map.put(nums[i], i);
			}
		}
		
		return result;
	}

}
