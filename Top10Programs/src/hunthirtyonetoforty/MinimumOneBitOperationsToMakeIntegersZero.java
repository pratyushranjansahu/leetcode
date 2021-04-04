package hunthirtyonetoforty;
///https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/discuss/877798/JavaC++Python-3-Solutions-with-Prove-O(1)-Space
public class MinimumOneBitOperationsToMakeIntegersZero {

	public static void main(String[] args) {
		int n=3;
		System.out.println(minimumOneBitOperations(n));

	}
	public static int minimumOneBitOperations(int n) {
        return minimumOneBitOperations(n,0);
        
    }
    
    public static int minimumOneBitOperations(int n, int res) {
        if (n == 0) return res;
        int b = 1;
        while ((b << 1) <= n)
            b = b << 1;
        return minimumOneBitOperations((b >> 1) ^ b ^ n, res + b);
    }

}
