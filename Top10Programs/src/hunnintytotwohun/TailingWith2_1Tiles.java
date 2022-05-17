package hunnintytotwohun;
/*
 * https://www.geeksforgeeks.org/tiling-problem/
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling1-official/ojquestion
 * https://www.youtube.com/watch?v=dVT9JeUMMDE
 */
public class TailingWith2_1Tiles {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(tailing(n));//5
    }
    private static int tailing(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
