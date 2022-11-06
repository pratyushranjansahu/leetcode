package practiceinorder.p_41;

public class CountBits {

	public static void main(String[] args) {
		int n=5;
		countBits(n);

	}

	private static int[] countBits(int n) {
		int[] bitArray=new int[n+1];
		for (int i = 1; i < bitArray.length; i++) {
			bitArray[i]=bitArray[i>>1]+i%2;
		}
		return bitArray;
	}

}
