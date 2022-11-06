package practiceinorder.p_131;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    https://leetcode.com/problems/brick-wall/
    https://www.youtube.com/watch?v=bKt63YABdNw
 */
public class BrickWall {
    public static void main(String[] args) {
        //[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
    }
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> list : wall) {
            int ps = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int val = list.get(i);
                ps += val;
                map.put(ps,map.getOrDefault(ps,0)+1);
                max = Math.max(max,map.get(ps));
            }
        }
        return wall.size() - max;
    }
}
