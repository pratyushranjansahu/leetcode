package practiceinorder.eletotwe;

public class AdditiveNumber {

	public static void main(String[] args) {
		String s="11235";
		System.out.println(isAdditiveNumber(s));

	}
	
	private static boolean isAdditiveNumber(String s) {
		for(int i=1;i<s.length()-1;i++) {
			long n1=Long.parseLong(s.substring(0, i));
			if(!s.substring(0, i).equals(Long.toString(n1)))
				break;
			for(int j=i+1;j<s.length();j++) {
				long n2=Long.parseLong(s.substring(i, j));
				if(!s.substring(i, j).equals(Long.toString(n2)))
					break;
				boolean found=find_rec(n1,n2,s.substring(j),false);
				if(found)
					return true;
			}
					
		}
		return false;
		
	}
private static boolean find_rec(long n1,long n2,String s,boolean found) {
	if(s.length()==0 && found) 
		return true;
	String n3=Long.toString(n1+n2);
	int idx=Math.min(s.length(), n3.length());
	if(s.substring(0, idx).equals(n3))
		return find_rec(n2, Long.parseLong(n3), s.substring(idx), true);
			
	return false;
	
}

}
