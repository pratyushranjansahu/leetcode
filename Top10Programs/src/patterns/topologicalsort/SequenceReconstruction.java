package patterns.topologicalsort;

import java.util.*;
/*
    https://leetcode.com/problems/sequence-reconstruction/
    https://wentao-shao.gitbook.io/leetcode/toposort/444.sequence-reconstruction
 */
public class SequenceReconstruction {
    public static void main(String[] args) {
        int[] org = {1,2,3};
        List<List<Integer>> seqs = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        seqs.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(3);
        seqs.add(list);
        list = new ArrayList<>();
        list.add(2);
        list.add(3);
        seqs.add(list);
        System.out.println(sequenceReconstruction(org, seqs));//true
    }
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> seq: seqs) {
            if (seq.size() == 1) {
                System.out.println("Sequence size is 1");
                if (!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            } else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    if (!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }

                    if (!map.containsKey(seq.get(i+1))) {
                        map.put(seq.get(i+1), new HashSet<>());
                        indegree.put(seq.get(i+1), 0);
                    }

                    if (map.get(seq.get(i)).add(seq.get(i+1))) {
                        indegree.put(seq.get(i+1), indegree.get(seq.get(i+1)) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if (entry.getValue() == 0)
                queue.offer(entry.getKey());
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1){
                return false;
            }

            int curr = queue.poll();
            if (index == org.length || curr != org[index++])        return false;
            for (int next: map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0)        queue.offer(next);
            }
        }

        return index == org.length && index == map.size();
    }
}
