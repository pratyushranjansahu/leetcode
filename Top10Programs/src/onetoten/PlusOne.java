package onetoten;

public class PlusOne {

	public static void main(String[] args) {
		int[] arr= {9,9,9,9};
		int[] retArr=plusOne(arr);
		for (int i : retArr) {
			System.out.println(i);
		}
	}
	private static int[] plusOne(int[] digits) {
		int[] result=new int[digits.length+1];
		
		for (int i = digits.length-1; i >=0; i--) {
			if(digits[i]==9)
				digits[i]=0;
			else {
				digits[i]+=1;
				return digits;
			}
		}
		result[0]=1;
		return result;
	}

}
