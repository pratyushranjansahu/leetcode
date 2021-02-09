package eightyonetoninety;

public class ExcelSheetColumnumber {

	public static void main(String[] args) {
		String s="AA";
		System.out.println(titleToNumber(s));

	}
	  private static  int titleToNumber(String s) {
          int result = 0;
        for(char c : s.toCharArray()){
            int d = c - 'A' + 1;
            result = result*26 + d;
        }
        return result;
    }
}
