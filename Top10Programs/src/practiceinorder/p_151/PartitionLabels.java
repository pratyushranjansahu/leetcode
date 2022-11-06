package practiceinorder.p_151;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    https://leetcode.com/problems/partition-labels/
    https://www.youtube.com/watch?v=_I9di3CUOx4&t=1203s
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(str));//[9,7,8]
    }
    private static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int prev = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if (max == i) {
                res.add(max-prev);
                prev = max;
            }
        }
        return res;
    }
}
