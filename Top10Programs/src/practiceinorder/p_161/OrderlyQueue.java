package practiceinorder.p_161;

import java.util.Arrays;

/*
    https://leetcode.com/problems/orderly-queue/
    https://www.youtube.com/watch?v=pzClQP577Bo&t=621s
 */
public class OrderlyQueue {
    public static void main(String[] args) {
        String s = "baaca";
        int k = 3;
        System.out.println(orderlyQueue(s,k));
    }

    public static String orderlyQueue(String s, int k) {
        if(k > 1){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        String s_min = s;
        for(int i = 0; i < s.length(); ++i){
            s = s.substring(1) + s.charAt(0);
            s_min = s_min.compareTo(s) < 0 ? s_min : s;
        }
        return s_min;
    }
}
