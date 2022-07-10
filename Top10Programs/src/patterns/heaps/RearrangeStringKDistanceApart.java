package patterns.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
    Leet code
    https://www.youtube.com/watch?v=LAecOWxSk1M&t=662s
 */
public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
       String s = "aabbcc";
        // String s = "aaadbbcc";
        //String s = "aaabc";
        int k = 2;
        System.out.println(rearrangeString(s,k));//abcabc
    }
    public static String rearrangeString(String s, int k) {
        int n = s.length();
        if (n <= 1 || k <= 1) return s;
        Map<Character,Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        Comparator<Pair> comp = (a,b) -> (b.frequency - a.frequency == 0 ? a.ch - b.ch : b.frequency - a.frequency);
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(comp);
        for (Map.Entry<Character,Integer> entries : map.entrySet()) {
            Pair pair = new Pair(entries.getKey(), entries.getValue());
            priorityQueue.add(pair);
        }
        StringBuilder sb = new StringBuilder();
        while (priorityQueue.size() >= k) {
            /*for (int i = 0; i < k; i++) {
                Pair pair = priorityQueue.poll();
                sb.append(pair.ch);
                pair.frequency--;
                if (pair.frequency > 0) {
                    priorityQueue.add(pair);
                }
            }*/
            Pair[] pairArr = new Pair[k];
            for (int i = 0; i < k; i++) {
                pairArr[i] = priorityQueue.poll();
            }
            for (int i = 0; i < k; i++) {
                sb.append(pairArr[i].ch);
                pairArr[i].frequency--;
                if (pairArr[i].frequency > 0) {
                    priorityQueue.add(pairArr[i]);
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            sb.append(pair.ch);
            pair.frequency--;
            if (pair.frequency > 0)
                return "";
        }
        return sb.toString();
    }
    static class Pair {
        char ch;
        int frequency;
        public Pair(char ch,int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

    }
}
