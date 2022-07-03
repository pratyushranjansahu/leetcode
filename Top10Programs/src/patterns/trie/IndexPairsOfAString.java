package patterns.trie;

import java.util.ArrayList;
import java.util.List;
/*
 * Leetcode 1065
 * https://github.com/lydxlx1/LeetCode/blob/master/src/_1065.java
 */
public class IndexPairsOfAString {

    public static void main(String[] args) {
        String text = "ababa";
        String[] words = {"aba","ab"};
        int[][] mat = indexPairs(text, words);//[[0,1],[0,2],[2,3],[2,4]]
        for (int i = 0; i < mat.length; i++){

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println("");
        }
    }
    static class Trie {
        boolean is = false;
        Trie[] ch = new Trie[26];
    }

    static void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (root.ch[ch] == null) {
                root.ch[ch] = new Trie();
            }
            root = root.ch[ch];
        }
        root.is = true;
    }

    public static int[][] indexPairs(String text, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            insert(root, word);
        }

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            Trie node = root;
            for (int j = i; j < text.length(); j++) {
                int ch = text.charAt(j) - 'a';
                if (node.ch[ch] == null) {
                    break;
                }

                node = node.ch[ch];
                if (node.is) {
                    ans.add(new int[] { i, j });
                }
            }
        }
        return ans.stream().toArray(int[][]::new);
    }

}
