package twohuntwintytothirty;
/*
    https://leetcode.com/problems/longest-repeating-character-replacement/
    https://www.youtube.com/watch?v=00FmUN1pkGE
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int  k = 2;
        System.out.println(characterReplacement(s, k ));
    }
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charCount = new int[26];
        int windowStart = 0;
        int maxLength = 0;
        int maxCount = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            charCount[s.charAt(windowEnd) - 'A']++;
            int currentCharCount = charCount[s.charAt(windowEnd) - 'A'];
            maxCount = Math.max(maxCount, currentCharCount);
            while (windowEnd - windowStart -maxCount + 1 > k) {
                charCount[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
