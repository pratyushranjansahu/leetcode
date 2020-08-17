package sixtyonetoseventy;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(27));

	}
	private static String convertToTitle(int n) {
		String result="";
		while(n>0) {
			char c=(char)('A'+(n-1)%26);
			result=c+result;
			n=(n-1)/26;
		}
		return result;
	} 

}
