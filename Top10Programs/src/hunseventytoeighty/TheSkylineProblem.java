package hunseventytoeighty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
/*
 * https://leetcode.com/problems/the-skyline-problem/
 * https://www.youtube.com/watch?v=POUMNJou4vc
 */
public class TheSkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        getSkyline(buildings);//[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
    }
    public static  List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list =new ArrayList();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < buildings.length; i++) {
            int sp = buildings[i][0];
            int ep = buildings[i][1];
            int ht = buildings[i][2];
            list.add(new Pair(sp, -ht));
            list.add(new Pair(ep, ht));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int cht = 0;
        pq.add(0);
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int ht = list.get(i).ht;
            if (ht < 0) {
                pq.add(-ht);
            }else {
                pq.remove(ht);
            }
            if (cht != pq.peek()) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(x);
                tmp.add(pq.peek());
                ans.add(tmp);
                cht = pq.peek();
            }
        }
        return ans;
    }
    static class Pair implements Comparable<Pair> {
        int x;
        int ht;
        public Pair(int x, int ht) {
            this.x = x;
            this.ht = ht;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return this.ht - o.ht;
        }

    }
}
