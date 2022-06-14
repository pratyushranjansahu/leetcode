package patterns.slidingwindow;

import java.util.HashSet;
import java.util.Set;
/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
    https://www.youtube.com/watch?v=jHj13UHURr8&t=318s
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));//3
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0 , right = 0;
        Set<Character> seen = new HashSet();
        int max = 0;

        while(right<s.length()){
            char c = s.charAt(right); //a
            if(seen.add(c)){
                max = Math.max(max,right-left+1);
                right++;
            }else{
                while(s.charAt(left)!=c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);left++;
            }
        }
        return max;
    }
}
