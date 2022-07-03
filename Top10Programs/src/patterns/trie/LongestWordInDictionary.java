package patterns.trie;
/*
 * https://leetcode.com/problems/longest-word-in-dictionary/
 * https://www.youtube.com/watch?v=MbvGOab6Sfg
 */
public class LongestWordInDictionary {
    public static void main(String[] args) {
        //String[] words = {"w","wo","wor","worl","world"};
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(words));
    }
    static class Trie {
        Trie[] children = new Trie[26];
        String str;
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

    public static void dfs(Trie root) {
        for (Trie child : root.children) {
            if (child != null && child.str != null) {
                if (child.str.length() > ans.length()) {
                    ans = child.str;
                }
                dfs(child);
            }
        }
    }

    static String ans = "";
    public static String longestWord(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            insert(root, word);
        }
        dfs(root);
        return ans;
    }
}
