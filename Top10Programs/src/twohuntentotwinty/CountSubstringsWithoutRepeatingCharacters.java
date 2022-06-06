package twohuntentotwinty;

import java.util.HashMap;
import java.util.Map;
/*
    https://www.youtube.com/watch?v=Auk0E3E8G7c
 */
public class CountSubstringsWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aabcbcdbca";
        System.out.println(solution(s));//24
    }
    private static int solution (String s) {
        int ans = 0;
        int i = -1, j = -1;
        Map<Character,Integer> map = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length() - 1) {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                } else {
                    ans += i - j;
                }
            }
            while (j < i) {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    ans += i-j;
                    break;
                }
            }
            if (f1 == false && f2 == false)
                break;
        }
        return ans;
    }
}
