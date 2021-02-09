package fortyonetofifty;

public class DecodeWays {

	public static void main(String[] args) {
		//String s="226";
		String s="12";
		System.out.println(numDecodings(s));

	}
	
	private static int numDecodings(String s) {
		if(s.length()<=0) return 0;
		if(s.charAt(0)=='0') return 0;
		if(s.length()==1) return 1;
		
		int val1=1,val2=1;
		for(int i=1;i<s.length();i++) {
			int val=0;
			int d1=s.charAt(i)-'0';
			int d2=(s.charAt(i-1)-'0')*10+d1;
			if(d1>=1)
				val+=val2;
			if(d2>=10 && d2<=26)
				val+=val1;
			val1=val2;
			val2=val;
			
		}
		return val2;
	}
	

}
