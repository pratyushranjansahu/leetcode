package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/letter-case-permutation/
    https://www.youtube.com/watch?v=Yb925KsSsy4&t=555s
 */
public class LetterCasePermutation {
    static List<String> res = new ArrayList<>();
    static int count = 1;
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));//[a1b2, A1b2, a1B2, A1B2]
    }
    public static List<String> letterCasePermutation(String s) {
        res.add(s.toLowerCase());
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                addToList(Character.toUpperCase(s.charAt(i)),i);
            }
        }
        return res;
    }

    private static void addToList (char ch, int pos) {
        int i = 0;
        while (i < count) {
            String x = res.get(i);
            StringBuilder sb = new StringBuilder(x);
            sb.setCharAt(pos,ch);
            res.add(sb.toString());
            i++;
        }
        count += count;
    }

}
