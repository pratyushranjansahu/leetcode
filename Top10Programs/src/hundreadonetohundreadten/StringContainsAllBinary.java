package hundreadonetohundreadten;

import java.util.HashSet;

public class StringContainsAllBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean hasAllCodes(String s, int k) {
        int count  = 0;
        int start = 0;
        HashSet<String> seen = new HashSet<>();

        for (int i=0;i<s.length();i++){
            count++;
            if (count==k){
                seen.add(s.substring(start,k+start));
                count--;
                start++;
            }
        }
        return seen.size()==Math.pow(2,k);
    }

}
