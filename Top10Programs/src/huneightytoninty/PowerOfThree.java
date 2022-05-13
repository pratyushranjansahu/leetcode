package huneightytoninty;
/*
 * https://leetcode.com/problems/power-of-three/
 * https://www.youtube.com/watch?v=UncqP2F4t_0&t=111s
 */
public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));//true
    }
    public static boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        while (n%3 == 0) {
            n /= 3;
        }
        return n==1;
    }
}
