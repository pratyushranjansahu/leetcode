package patterns.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
/*
    https://www.youtube.com/watch?v=hM7-4viROWo
 */
public class KahnsAlgorithm {
    private static int[] findOrder(int numberOfCourses, ArrayList<ArrayList<Integer>> graph){
        int[] indegree = new int[numberOfCourses];
        int[] ans = new int[numberOfCourses];
        for (int i = 0; i < numberOfCourses; i++) {
            for (int nbrs : graph.get(i)) {
                indegree[nbrs]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numberOfCourses; i++) {
            if (indegree[i] == 0)
                queue.addLast(i);
        }
        int idx = 0;
        while (queue.size() > 0) {
            int rem = queue.removeFirst();
            ans[idx] = rem;
            idx++;
            for (int nbrs : graph.get(rem)) {
                indegree[nbrs]--;
                if (indegree[nbrs] == 0){
                    queue.addLast(nbrs);
                }
            }
        }
        if (idx == numberOfCourses) {
            return ans;
        }
        return new int[]{};
    }
}
