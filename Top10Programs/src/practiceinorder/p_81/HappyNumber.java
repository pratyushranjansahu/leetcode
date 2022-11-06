package practiceinorder.p_81;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		int n = 1;
		System.out.println(isHappy(n));

	}

	private static boolean isHappy(int n) {
		if(n<0) return false;
		Set<Integer> set=new HashSet();
		while(!set.contains(n)) {
			set.add(n);
			n=sumOfSquare(n);
			if(n==1) return true;
		}
		return false;
	}

	private static int sumOfSquare(int n) {
		int sum = 0;
		while (n > 0) {
			int d = n % 10;
			sum += d * d;
			n /= 10;
		}
		return sum;
	}

}
