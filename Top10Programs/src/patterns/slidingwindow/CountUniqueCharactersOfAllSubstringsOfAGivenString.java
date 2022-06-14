package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
    https://www.youtube.com/watch?v=eN8zATT702M
 */
public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(uniqueLetterString(s));//10
    }
    public static int uniqueLetterString(String s) {
        Map<Character, List<Integer>> allIndexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            allIndexes.computeIfAbsent(s.charAt(i), k-> new ArrayList<Integer>()).add(i);
        int sum = 0;
        for (List<Integer> indexes : allIndexes.values())
            for (int i = 0; i < indexes.size(); i++) {
                int left = i == 0 ? indexes.get(i) + 1 : indexes.get(i) - indexes.get(i-1);
                int right = i == indexes.size() - 1 ? s.length() - indexes.get(i) : indexes.get(i+1) - indexes.get(i);
                sum += left * right;
            }
        return sum;
    }
}
