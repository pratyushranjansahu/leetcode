package patterns.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*
    https://leetcode.com/problems/word-search-ii/
    https://www.youtube.com/watch?v=3PT9QjgYTQc&t=656s
 */
public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board, words));// ["eat","oath"]
    }
    public static List<String> findWords(char[][] board, String[] words) {

        if(words.length == 0) return new ArrayList<String>();
        List<String> res = new ArrayList();
        HashSet<String> set = new HashSet<>();
        Trie t = new Trie();
        for (String w : words)
            t.insert(w);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, t, set, "");
            }
        }
        res.addAll(set);
        return res;
    }
    private static void dfs(char[][] board, int i, int j, Trie trie, HashSet<String> result, String s){

        char c = board[i][j];
        if (c == '$')
            return;
        board[i][j] = '$';
        Trie t = trie.children[c - 'a'];
        if (t != null) {
            String ss = s + c;
            if (t.endOfWord)
                result.add(ss);
            if (i > 0)
                dfs(board, i - 1, j, t, result, ss);
            if (i < board.length - 1)
                dfs(board, i + 1, j, t, result, ss);
            if (j > 0)
                dfs(board, i, j - 1, t, result, ss);
            if (j < board[0].length - 1)
                dfs(board, i, j + 1, t, result, ss);
        }
        board[i][j] = c;
    }
    static class Trie{
        Trie[] children;
        boolean endOfWord;

        Trie() {
            children = new Trie[26];
            endOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

        public void insert(String word) {
            Trie curr = this;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                    // curr=curr.children[c-'a'];
                }
                curr = curr.children[c - 'a'];

            }
            curr.endOfWord = true;

        }
    }
}
