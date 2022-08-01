package patterns.topologicalsort;

import java.util.*;
import java.util.stream.Collectors;
/*
    https://leetcode.com/problems/course-schedule-ii/
    https://www.youtube.com/watch?v=hM7-4viROWo
    https://www.youtube.com/watch?v=_BGK0kpE4oE&t=307s
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        //int numCourses = 2; int[][] prerequisites = {{1,0}};
        int numCourses = 4; int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] res = findOrder(numCourses,prerequisites);//[0, 1]
        System.out.println(Arrays.stream(res)
                .boxed()
                .collect(Collectors.toList()));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            int course = prereq[0];
            int dependingCourse = prereq[1];
            // Egde from dependingCourse towards the current course
            graph.get(dependingCourse).add(course);

        }

        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int nbrs : graph.get(i)) {
                indegree[nbrs]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
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
        if (idx == numCourses) {
            return ans;
        }
        return new int[]{};
    }

}
