package practiceinorder.p_91;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

	public static void main(String[] args) {
		String S="I speak Goat Latin";
		System.out.println(toGoatLatin(S));

	}
	
	 private static String toGoatLatin(String S) {
         StringBuilder sb = new StringBuilder();
        String suffix = "";
        Character[] vowelsarr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowels = new HashSet(Arrays.asList(vowelsarr));
        
        for(String word: S.split(" ")){
            suffix += 'a';
            if(!vowels.contains(word.charAt(0)))
                word = word.substring(1) + word.charAt(0);
            sb.append(word).append("ma").append(suffix).append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
