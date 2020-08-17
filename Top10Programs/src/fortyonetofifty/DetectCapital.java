package fortyonetofifty;

public class DetectCapital {

	public static void main(String[] args) {
		String s="abC";
		System.out.println(isValid(s));

	}
	
	private static boolean isValid(String s) {
		if(s.length()<2) return true;
		if(Character.isUpperCase(s.charAt(0))&& Character.isUpperCase(s.charAt(1))){
			for(int i=2;i<s.length();i++) {
			if(Character.isLowerCase(s.charAt(i))) return false;	
			}
			
		}else {
			for(int i=1;i<s.length();i++) {
				if(Character.isUpperCase(s.charAt(i))) return false;
		}
		}
		return true;
	}

}
