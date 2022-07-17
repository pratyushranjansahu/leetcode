package patterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
	https://leetcode.com/problems/3sum/
	https://www.youtube.com/watch?v=Ca7k53qcTic&t=1156s
 */
public class ThreeSum {

	public static void main(String[] args) {
		//int[] arr = {-1, 0, 1, 2, -1, -4};
		int[] arr = {3,0,-2,-1,1,2};
		System.out.println(threeSum(arr));
	}

	private static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> result = new ArrayList();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-2; i++) {
			//if(arr[i]!=arr[i+1]) {
			 if(i == 0 || arr[i] != arr[i-1]){
				int j=i+1;
				int k=arr.length-1;
				while(j<k) {
					int sum=arr[i]+arr[j]+arr[k];
					if(sum==0) {
						List<Integer> list=new ArrayList<>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[k]);
						result.add(list);
						while(j<k && arr[j]==arr[j+1]) j++;
						while(j<k && arr[k]==arr[k-1]) k--;
						j++;
						k--;
					}else if(sum<0)
						j++;
					else
						k--;
					
					
				}
			}
			
		}
		return result;
	}

}
