package hunsixtytoseventy;
/*
 * https://leetcode.com/problems/consecutive-numbers-sum/
 * https://www.youtube.com/watch?v=EiC2eIlYu_w&t=1078s
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(consecutiveNumbersSum(n)); //4
    }
    private static int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 1; 2 * n > i * (i-1); i++) {
            int number = n - (i * (i-1) /2 );
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }
}
