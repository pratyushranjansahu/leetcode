package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/palindrome-partitioning/
    https://www.youtube.com/watch?v=-sZuqMiqn3g&list=PLEI-q7w3s9gQIB_urBmMV04f_NBelXJEP&index=9&t=5s
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));//[[a, a, b], [aa, b]]
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res  = new ArrayList<>();
        if(s == null || s.length()==0){
            return res;
        }

        helper(res, new ArrayList<>(), s);
        return res;
    }

    private static void helper(List<List<String>> res, List<String> currList, String inputStr){
        if(inputStr.length() == 0){
            res.add(new ArrayList<>(currList));
            return ;
        }
        for(int i=0;i<inputStr.length();i++){
            String firstPart = inputStr.substring(0, i+1);
            if(isPalindrome(firstPart)){
                currList.add(firstPart);
                String secondPart = inputStr.substring(i+1, inputStr.length());
                helper(res, currList, secondPart);
                currList.remove(currList.size() -1);

            }
        }
    }

    private static boolean isPalindrome(String s){
        String reversedStr = new StringBuilder(s).reverse().toString();
        return s.equals(reversedStr);
    }
}
