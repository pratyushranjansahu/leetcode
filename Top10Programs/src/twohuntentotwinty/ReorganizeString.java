package twohuntentotwinty;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
    public static String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue(map.size(), Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entries : map.entrySet()) {
            pq.add(new Pair(entries.getKey(), entries.getValue()));
        }

        Pair block = pq.poll();
        sb.append(block.ch);
        block.frequency--;
        while (pq.size() > 0) {
            Pair temp = pq.poll();
            sb.append(temp.ch);
            temp.frequency--;
            if (block.frequency > 0) {
                pq.add(block);
            }
            block = temp;
        }
        if (block.frequency > 0) {
            return "";
        }
        return sb.toString();
    }
    static class Pair implements Comparable<Pair>{
        char ch;
        int frequency;
        public Pair(char ch,int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.frequency - o.frequency;
        }

    }
}
