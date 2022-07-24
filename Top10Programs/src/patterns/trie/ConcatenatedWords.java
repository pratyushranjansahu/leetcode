package patterns.trie;

import java.util.ArrayList;
import java.util.List;
/*
 * https://leetcode.com/problems/concatenated-words/
 * https://www.youtube.com/watch?v=yHFpb07ukLY&t=3518s
 */
public class ConcatenatedWords {

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }
    static class Trie {
        Trie[] children = new Trie[26];
        String str;
        boolean added;
    }

    static Trie root;
    static ArrayList<String> ans = new ArrayList();
    public static void search1(Trie curr) {
        if (curr.str != null) {
            search(curr, root);
        }
        for (Trie child : curr.children) {
            if (child != null) {
                search1(child);
            }
        }
    }
    public static void search(Trie curr, Trie newWord){
        if (curr.str != null && newWord.str != null) {
            if (curr.added == false)
                ans.add(curr.str);
            curr.added = true;
        }
        if (newWord.str != null) {
            search(curr, root);
        }
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && newWord.children[i] != null) {
                search(curr.children[i], newWord.children[i]);
            }
        }
    }
    public static void insert(Trie curr, String word){
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Trie();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.str = word;
    }
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {

        root = new Trie();
        for (String word : words) {
            insert(root,word);
        }
        search1(root);
        return ans;
    }


}
