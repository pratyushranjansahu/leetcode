package practiceinorder.p_171;
/*
    https://leetcode.com/problems/count-numbers-with-unique-digits/
    https://www.youtube.com/watch?v=nrDNGVW59c8
 */
public class CountNumberswithUniqueDigits {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countNumbersWithUniqueDigits(n));//91
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int ans = 10;
        int start = 9;
        int current = 9;

        while(n-- > 1){
            current *= start--;
            ans += current;
        }

        return ans;
    }
}
