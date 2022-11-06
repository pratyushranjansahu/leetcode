package practiceinorder.p_51;

public class ReomoveAllAdjecentRecursively {

	public static void main(String[] args) {
		//String s="azxxzy";

		String s="aabc";
		System.out.println(removeAdjecent(s));
	}

	private static String removeAdjecent(String s) {
		
		char lastChar=s.charAt(0);
		int position=0;
		int i=1;
		for(i=1;i<s.length();i++) {
			if(lastChar==s.charAt(i)) {
				position++;
				continue;
			}else {
				lastChar=s.charAt(i);
			}
			if(position>0)
				break;
		}
		if(position==0) return s;
		
		
		return removeAdjecent(s.substring(0,i-(position+1))+s.substring(i,s.length()));
	}

}
