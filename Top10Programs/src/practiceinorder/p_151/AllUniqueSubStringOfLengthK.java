package practiceinorder.p_151;

import java.util.HashSet;
import java.util.Set;

//asked in GS
public class AllUniqueSubStringOfLengthK {

	public static void main(String[] args) {
		String s="abcc";
		int k=2;
		System.out.println(findSubString(s,k));

	}
	
	private static Set<String> findSubString(String s,int k){
		
		Set<String> set=new HashSet();
		if(s.length()<k)
			return set;
		int start=0;int count=0;
		for(int i=0;i<s.length();i++) {
			count++;
			if(count==k) {
				set.add(s.substring(start,start+k));
				count--;
				start++;
			}
		}
		
		return set;
	}

}
