package hunthirtyonetoforty;
//https://www.youtube.com/watch?v=J7rqc7pbwkI&t=39s
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String str="cbbd";
		System.out.println(longestPalindromeSubseq(str));

	}
	 public static int longestPalindromeSubseq(String s) {
         String text1 = s;
        String text2 = new StringBuilder(s).reverse().toString();
        
        
         int[][] dp = new int[text1.length()+1][text2.length()+1];
        
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               if(text1.charAt(i-1)==text2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1]+1;
               }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
               }
           }
       }     
       return dp[text1.length()][text2.length()]; 
    }

}
