package patterns.trie;
/*
    https://leetcode.com/problems/prefix-and-suffix-search/
    https://www.youtube.com/watch?v=vWs5iOHqnlY&t=767s
 */
public class PrefixAndSuffixSearch {
    public static void main(String[] args) {
        String[] words = {"bat","apple"};
        String prefix = "a";
        String suffix = "e";
        WordFilter obj = new WordFilter(words);

        int param_1 = obj.f(prefix,suffix);
        System.out.println(param_1);// 1 As apple is in 1st index of the words array
    }
}
class WordFilter {
    TrieNode trie;
    public WordFilter(String[] words) {
        trie = new TrieNode();
        for (int weight = 0; weight < words.length; ++weight) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); ++i) {
                TrieNode cur = trie;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; ++j) {
                    char ch = word.charAt(j % word.length());
                    //System.out.println("Character is : "+ch);
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null) {
                      //  System.out.println("creating new Trie");
                        cur.children[k] = new TrieNode();
                    }
                    cur = cur.children[k];
                    cur.weight = weight;
                }

            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        for (char letter: (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }
}
class TrieNode {
    TrieNode[] children;
    int weight;
    public TrieNode() {
        children = new TrieNode[27];
        weight = 0;
    }
}
