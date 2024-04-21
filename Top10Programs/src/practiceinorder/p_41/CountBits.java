package practiceinorder.p_41;
/*
  https://leetcode.com/problems/counting-bits/description/
  https://www.youtube.com/watch?v=PUSVTRzqEWE
 */
public class CountBits {

	public static void main(String[] args) {
		int n=5;
		int[] arr = countBits(n);
		for(int a : arr)
			System.out.print(a+" ");//0 1 1 2 1 2

	}

	private static int[] countBits(int num) {
		int[] ans = new int[num + 1];

		for(int i =0; i <=num; i++)
			ans[i] =rec(i, ans);

		return ans;
	}

	private static int rec(int num, int memo[]){
		if(num == 0)    return 0;
		if(num == 1)    return 1;
		if(memo[num] != 0) return memo[num];

		if(num%2 == 0){
			memo[num] =rec(num/2, memo);
			return rec(num/2, memo);
		}
		else{
			memo[num] =1 + rec(num/2, memo);
			return 1+rec(num/2, memo);
		}
	}

}
