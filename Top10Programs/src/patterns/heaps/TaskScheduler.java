package patterns.heaps;

import java.util.*;
/*
	https://leetcode.com/problems/task-scheduler/
	https://www.youtube.com/watch?v=tGw5GbDekTU&t=411s
 */
public class TaskScheduler {

	public static void main(String[] args) {
		//char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B','C','D' };
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int k = 2;
		System.out.println(leastInterval(tasks, k));//8
	}

	private static int leastInterval(char[] tasks, int n) {
		int result = 0;
		Map<Character, Integer> counts = new HashMap();
		for (char t : tasks)
			counts.put(t, counts.getOrDefault(t, 0) + 1);
		PriorityQueue<Integer> pq = new PriorityQueue(counts.size(), Collections.reverseOrder());
		pq.addAll(counts.values());

		while (!pq.isEmpty()) {
			int time = 0;
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < n + 1; i++) {
				if (!pq.isEmpty()) {
					tmp.add(pq.remove() - 1);
					time++;
				}
			}
			for (int t : tmp)
				if (t > 0)
					pq.add(t);
			result += pq.isEmpty() ? time : n + 1;
		}
		return result;
	}
}
