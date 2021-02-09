package fiftyonetosixty;

import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubArrays {

	public static void main(String[] args) {
		int[] target = {1,2,3,4,4}, arr = {2,4,1,3};
		System.out.println(canBeEqual(target,arr));

	}
	private static  boolean canBeEqual(int[] target, int[] arr) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int x : target) 
			map.put(x, map.getOrDefault(x, 0)+1);
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i]) && map.get(arr[i])>0) {
				map.put(arr[i], map.get(arr[i])-1);
			}else {
				return false;
			}
		}		
		return true;
	}
}
