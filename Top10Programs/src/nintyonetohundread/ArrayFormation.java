package nintyonetohundread;

import java.util.HashMap;
import java.util.Map;

public class ArrayFormation {

	public static void main(String[] args) {
		int[] arr= {85};
		int[][] pices= {{85}};
		System.out.println(canFormArray(arr,pices));

	}
	
	   public static  boolean canFormArray(int[] arr, int[][] pieces) {
	        Map<Integer, int[]> _map = new HashMap<>();
	        for(int[] p: pieces)
	            _map.put(p[0], p);
	        
	        int idx = 0;
	        while(idx < arr.length){
	            if(_map.containsKey(arr[idx])){
	                int[] piece = _map.get(arr[idx]);
	                for(int p: piece){
	                    if(p != arr[idx]) return false;
	                    else idx++;
	                }
	            } else 
	                return false;
	        }
	        return true;
	    }

}
