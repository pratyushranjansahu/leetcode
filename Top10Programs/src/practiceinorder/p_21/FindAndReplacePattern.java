package practiceinorder.p_21;

import java.util.*;

/*
    https://leetcode.com/problems/find-and-replace-pattern/
    https://www.youtube.com/watch?v=4Ze_vLq5tPQ
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));//Output: ["mee","aqq"]
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words){
            if(isMatching(word, pattern)){
                res.add(word);
            }
        }
        return res;
    }
    private static boolean isMatching(String word, String pattern){
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < pattern.length(); i++) {
            char wch = word.charAt(i);
            char pch = pattern.charAt(i);

            if (map.containsKey(pch) == true) {
                if (map.get(pch) != wch){
                    return false;
                }
            } else {
                if (set.contains(wch)) {
                    return false;
                }

                map.put(pch, wch);
                set.add(wch);
            }
        }
        return true;
    }
}
