package seventyonetoeighty;

public class LastWordLength {

	public static void main(String[] args) {
		String s="Hello123 world 123";
		System.out.println(getLength(s));

	}
	
	private static int getLength(String s) {
		int count=0;
		int n=s.length();
		int i=0;
		while(i<n) {
			if(s.charAt(i)!=' ') {
				count++;i++;
			}else {
				while(i<n && s.charAt(i)==' ') i++;
				if(i==n)return count;
				else count=0;
			}
		}
		return count;
	}

}
