package twohuntentotwinty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    https://leetcode.com/problems/substring-with-concatenation-of-all-words/
    https://www.youtube.com/watch?v=mIY9saZy4o0
 */
public class SubstringWithConcatenationOfAllWord {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words ={"foo","bar"};
        System.out.println(findSubstring(s, words));//[0, 9]
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int wordCount = words.length;
        int wordLength = words[0].length();
        for (int i = 0; i<= s.length()-(wordCount * wordLength); i++) {
            Map<String,Integer> seen = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                int nextIndexOfWord = i + j * wordLength;
                String nextWord = s.substring(nextIndexOfWord, nextIndexOfWord + wordLength);
                if (!map.containsKey(nextWord))
                    break;
                seen.put(nextWord,seen.getOrDefault(nextWord,0)+1);

                if (seen.get(nextWord) > map.get(nextWord))
                    break;
                if (j+1 == wordCount)
                    res.add(i);
            }
        }
        return res;
    }
}
