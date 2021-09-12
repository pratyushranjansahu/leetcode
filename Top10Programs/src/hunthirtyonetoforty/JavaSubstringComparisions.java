//https://www.youtube.com/watch?v=Wls4vOx365g
public class JavaSubstringComparisions {

	public static void main(String[] args) {
		String s = "welcometojava";
		int k = 3;
		System.out.println(getSmallestAndLargest(s, k));

	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		String currentString = s.substring(0, k);
		smallest = currentString;
		largest = currentString;
		for (int i = 1; i <= s.length() - k; i++) {
			currentString = s.substring(i, i + k);
			if (currentString.compareTo(smallest) < 0) {
				smallest = currentString;
			}
			if (currentString.compareTo(largest) > 0) {
				largest = currentString;
			}
		}

		return smallest + "\n" + largest;
	}

}
