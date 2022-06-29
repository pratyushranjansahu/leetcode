package patterns.topologicalsort;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/course-schedule/
    https://www.youtube.com/watch?v=iaaObeAEgxI&t=1376s
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses, prerequisites));//true
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(adj,visited,i))
                return false;
        }
        return true;
    }
    private static boolean dfs(List<Integer>[] adj, int[] visited, int v) {
        if (visited[v] == 1) return false;
        visited[v] = 1;
        for (int ad : adj[v]) {
            if (visited[ad] !=2 && !dfs(adj,visited, ad))
                return false;
        }
        visited[v] = 2;
        return true;
    }
}
