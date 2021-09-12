public class JavaStringReverse {

	public static void main(String[] args) {
		String s = "madam";
		printReverse(s);
	}

	private static void printReverse(String A) {
		char[] arr = A.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		boolean isPalindrome = true;
		while (start <= end) {
			if (arr[start] != arr[end]) {
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}
		if (isPalindrome) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
