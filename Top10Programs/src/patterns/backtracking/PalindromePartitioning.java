package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/palindrome-partitioning/
    https://www.youtube.com/watch?v=pkBG7lB-1N8&t=276s
    https://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/#:~:text=Given%20a%20string%20s%2C%20partition,possible%20palindrome%20partitioning%20of%20s.&text=The%20dynamic%20programming%20approach%20is,problem%20of%20longest%20palindrome%20substring.

 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));//[[a, a, b], [aa, b]]
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();

        if (s == null || s.length() == 0) {
            return result;
        }

        List<String> partition = new ArrayList<String>();//track each possible partition
        addPalindrome(s, 0, partition, result);

        return result;
    }
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    private static void addPalindrome(String s, int start, List<String> partition,
                                      List<List<String>> result) {
        //stop condition
        if (start == s.length()) {
            List<String>temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
