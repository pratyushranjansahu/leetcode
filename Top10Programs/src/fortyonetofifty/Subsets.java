package fortyonetofifty;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		//int[] nums= {1,2,3};
		//System.out.println(findSubSet(nums));
		ArrayList<Integer> res=new ArrayList<Integer>();
		printFibonacciNumbers(5,res);
		long[] arr=new long[res.size()];
		System.out.println(res);

	}
	
	private static ArrayList<ArrayList<Integer>> findSubSet(int[] nums){
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<>());
		
		for(int x : nums) {
			int n=result.size();
			for(int i=0;i<n;i++) {
				ArrayList<Integer> l=new ArrayList<>(result.get(i));
				l.add(x);
				result.add(l);
			}
		}
		
		return result;
	}
	
	static void printFibonacciNumbers(int n,ArrayList<Integer> res)
    {
        int f1 = 0, f2 = 1, i;
 
        if (n < 1)
            return;
        //int[cnt++]=f1;
        res.add(f1);
        //System.out.print(f1 + " ");
        for (i = 1; i < n; i++) 
        {
            res.add(f2);
            //System.out.print(f2 + " ");
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
    }
    
}
