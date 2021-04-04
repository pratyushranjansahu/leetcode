package hunthirtyonetoforty;
//https://www.thecodingshala.com/2020/12/find-number-of-substrings-with-count-of-each-character-as-k.html?m=1#:~:text=A%20String%20s%20comprised%20of,substring%20occur%20exactly%20k%20times
public class PerfectSubString {

	public static void main(String[] args) {
		String s="1102021222";
			int k = 2;
		System.out.println(perfectSubstring(s, k));

	}
	public static  boolean check(int[] arr, int k) {
		for(int val : arr) {
			if(val != 0 && val != k) return false;
		}
		return true;
	}
	
	public static int perfectSubstring(String s, int k) {
		int res = 0;
		for(int i=0; i<s.length(); i++) {
			int[] arr = new int[10];
			for(int j = i; j<s.length(); j++) {
				if(j > i + (10*k)) break;
				char ch = s.charAt(j);
				arr[ch-'0']++;
				if(check(arr, k)) res++;
			}
		}
		return res;
	}

}
