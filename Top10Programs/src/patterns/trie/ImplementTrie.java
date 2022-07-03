package patterns.trie;
/*
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * https://www.youtube.com/watch?v=BN-SUKeOYC0
 */
public class ImplementTrie {

    public static void main(String[] args) {
        ImplementTrie obj = new ImplementTrie();
        String word = "apple";
        obj.insert(word);
        String searchWord = "ball";
        boolean param_2 = obj.search(searchWord);
        System.out.println("Searching word "+param_2);
        String prefix = "ap";
        boolean param_3 = obj.startsWith(prefix);
        System.out.println("Prefix : "+param_3);
    }

    private class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
        }
    }

    Node root;

    ImplementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}
