package patterns.topologicalsort;

import java.util.*;
/*
    https://leetcode.com/problems/minimum-height-trees/
    https://www.youtube.com/watch?v=ivl6BHJVcB0&t=189s
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        System.out.println(findMinHeightTrees(n, edges));
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n <= 0) {
            return res;
        }
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            while (size-- > 0) {
                int v = q.poll();
                for (int i : adj.get(v)) {
                    degree[i]--;
                    if (degree[i] == 1) {
                        q.add(i);
                    }
                }
            }
        }
        res.addAll(q);
        return res;
    }
}
