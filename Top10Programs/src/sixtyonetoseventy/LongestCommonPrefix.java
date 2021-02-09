package sixtyonetoseventy;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] arr= {"aeeksforgeeks","beeks","ceek","geezer"};
		System.out.println(commonPrefix(arr, arr.length));

	}
	
	private static String commonPrefix(String[] arr,int n) {
		int minLength=findMinimumLength(arr,n);
		String result="";
		char current;
		for(int i=0;i<minLength;i++) {
			current=arr[0].charAt(i);
			for(int j=1;j<n;j++) {
				if(arr[j].charAt(i)!=current)
					return result;					
			}
			result+=current;
		}
		return result;
	}
	
	private static int findMinimumLength(String[] arr,int n) {
		int minLength=arr[0].length();
		for(int i=1;i<n;i++) {
			if(minLength>arr[i].length())
				minLength=arr[i].length();
		}
		return minLength;
	}

}
