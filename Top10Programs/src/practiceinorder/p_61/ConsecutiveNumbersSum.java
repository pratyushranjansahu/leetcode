package practiceinorder.p_61;
/*
 * https://leetcode.com/problems/consecutive-numbers-sum/
 * https://www.youtube.com/watch?v=EiC2eIlYu_w&t=1078s
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(consecutiveNumbersSum1(n)); //4
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
    public static int consecutiveNumbersSum1(int N) {
        int totalCombinations=0;
        int i=1;
        while(N>0){
            if(N%i==0){
                totalCombinations++;
            }
            N-=i;
            i++;

        }

        return totalCombinations;
    }
}
