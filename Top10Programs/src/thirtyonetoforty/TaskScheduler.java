package thirtyonetoforty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B','C','D' };
		int k = 2;
		System.out.println(leastInterval(tasks, k));

	}

	private static int leastInterval(char[] tasks, int n) {
		int result = 0;
		Map<Character, Integer> counts = new HashMap();
		for (char t : tasks)
			counts.put(t, counts.getOrDefault(t, 0) + 1);
		//Comparator<Integer> comp=Collections.reverseOrder();
		PriorityQueue<Integer> pq = new PriorityQueue(counts.size(), Collections.reverseOrder());
		//PriorityQueue<Integer> pq=new PriorityQueue((a,b)-> -counts.get(a).compareTo(counts.get(b)));
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
