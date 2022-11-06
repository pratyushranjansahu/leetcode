package practiceinorder.p_41;

import java.util.Scanner;
/*
    https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-official/ojquestion
    https://www.youtube.com/watch?v=kh48JLieeW8
 */
public class PaintHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        long[][] dp = new long[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        long ans = Math.min(dp[n-1][0],Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(ans);
    }

}
