package practiceinorder.p_51;
/*
 * https://leetcode.com/problems/count-and-say/
 * https://www.youtube.com/watch?v=1YUqtoT9YoE
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));//1211
    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String s = "11";
        for (int i = 3; i <= n; i++) {
            String t = "";
            s += '&';
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    t += Integer.toString(count);
                    t += s.charAt(j - 1);
                    count = 1;
                } else
                    count++;

            }
            s = t;

        }
        return s;
    }
}
