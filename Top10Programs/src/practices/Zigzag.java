package practices;

import java.util.Arrays;
//https://leetcode.com/problems/rearrange-words-in-a-sentence/
public class Zigzag {

	public static void main(String[] args) {
		String text="Sun rises in the east";
		System.out.println(zigzag(text));

	}
	
	private static String zigzag(String text) {
		 String word[] = text.split(" ");
	        Arrays.sort(word, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
	        
	        StringBuilder sb = new StringBuilder();
	      //  sb.append(word[0].substring(0, 1).toUpperCase() + word[0].substring(1));
	        
	        /*for(int i = 1; i < word.length; i++) {
	            sb.append(" " + word[i].toLowerCase());
	        }*/
	        int l=0;
	        int r=word.length-1;
	        
	        while(l<r) {
	        	sb.append(word[l].toLowerCase()+" "+word[r]+" ");
	        	l++;
	        	r--;
	        }
	        sb.append(word[r].toLowerCase());
	        
	        return sb.toString().trim();
		
	}

}
