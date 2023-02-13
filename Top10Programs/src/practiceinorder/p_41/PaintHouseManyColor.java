package practiceinorder.p_41;

import java.util.Scanner;
/*
    https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-many-colors-official/ojquestion
    https://www.youtube.com/watch?v=jGywRalvoRw
 */
public class PaintHouseManyColor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] arr = new int[n][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[arr.length][arr[0].length];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for (int j = 0; j < arr[0].length; j++) {
            dp[0][j] = arr[0][j];
            if (arr[0][j] <= least) {
                sleast = least;
                least = arr[0][j];
            }else if (arr[0][j] <= sleast) {
                sleast = arr[0][j];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i-1][j]) {
                    dp[i][j] = sleast + arr[i][j];
                }else {
                    dp[i][j] = least + arr[i][j];
                }

                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                }else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;

        }
        System.out.println(least);
    }
}