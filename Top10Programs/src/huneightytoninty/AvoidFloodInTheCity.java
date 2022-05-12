package huneightytoninty;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
/*
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 * https://www.youtube.com/watch?v=Q_90h1fxCSM
 */
public class AvoidFloodInTheCity {
    public static void main(String[] args) {
        int[] rains = {69,0,0,0,69};
        avoidFlood(rains);//[-1,69,1,1,-1]
    }
    public static int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> lastRain = new HashMap<Integer, Integer>();
        TreeSet<Integer> dry = new TreeSet<Integer>();
        int n = rains.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = rains[i];
            if (x == 0) {
                dry.add(i);
                ans[i] = 1;
            }else {
                Integer id = lastRain.get(x);
                if (id == null) {
                    lastRain.put(x, i);
                }else {
                    Integer dryThisDay = dry.higher(id);
                    if (dryThisDay == null) {
                        return new int[0];
                    }
                    ans[dryThisDay] = x;
                    dry.remove(dryThisDay);
                    lastRain.put(x, i);
                }
                ans[i] = -1;
            }

        }
        return ans;
    }

}
