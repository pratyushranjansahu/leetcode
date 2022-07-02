package patterns.backtracking;

import java.util.*;
/*
    Actually in Trie but solved in backtracking
    https://www.youtube.com/watch?v=YTQjsPiMtRk
    https://massivealgorithms.blogspot.com/2016/10/leetcode-425-word-squares.html
 */
public class WordSquares {
    static Map<String,List<String>> map = new HashMap<>();
    public static void main(String[] args) {
        //String[] word = {"ball","area","lead","lady","able"};
        String[] word = {"area","lead","wall","lady","ball"};
        System.out.println(wordSquares(word));
    }
    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        createPrefixMap(words);
        for (int i = 0; i < words.length; i++) {
            LinkedList<String> list = new LinkedList<>();
            list.add(words[i]);
            backTrack(1,list,res,words[i].length());
        }
        return res;
    }
    private static void backTrack(int step, LinkedList<String> list, List<List<String>> res, int n) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word.charAt(step));
        }
        String prefix = sb.toString();
        List<String> wordList = map.getOrDefault(prefix, new ArrayList<>());
        for (String word : wordList) {
            list.add(word);
            backTrack(step + 1, list, res, n);
            list.removeLast();
        }
    }
    private static void createPrefixMap(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0,i);
                map.putIfAbsent(prefix, new ArrayList<>());
                List<String> list = map.get(prefix);
                list.add(word);
            }
        }
    }
}
