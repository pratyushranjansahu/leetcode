package practiceinorder.p_161;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/numbers-with-same-consecutive-differences/
    https://www.youtube.com/watch?v=TAfXh2l9FyA&t=1059s
 */
public class NumbersWithSameConsecutiveDifferences {

	public static void main(String[] args) {
		int N=2,K=0;
		numsSameConsecDiff(N, K);

	}
	
	 private static int[] numsSameConsecDiff(int N, int K) {
         List<Integer> result = new ArrayList();
        if(N == 1) result.add(0);
        for(int d = 1; d < 10; ++d)
            dfs(d, N-1, K, result);
        
        return result.stream().mapToInt(i->i).toArray();
    }
     
     private static void dfs(int num, int N, int K, List<Integer> result){
        if(N == 0){
            result.add(num);
            return;
        }
        int last_digit = num%10;
        if(last_digit >= K) 
        	dfs(num*10 + last_digit - K, N-1, K, result);
        if(K > 0 && last_digit + K < 10) 
        	dfs(num*10 + last_digit + K, N-1, K, result);
    }

}
