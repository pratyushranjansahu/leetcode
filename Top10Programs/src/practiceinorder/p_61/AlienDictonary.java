package practiceinorder.p_61;

import java.util.*;

/*
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/alien-dictionary-official/ojquestion
 * https://www.youtube.com/watch?v=_u1Mn4_2hIo&t=991s
 */
public class AlienDictonary {
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienDictonary(words));//wertf
    }
    private static String alienDictonary(String[] words) {
        Map<Character, Set<Character>> map = new HashMap();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                indegree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            boolean flag = false;
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                if (ch1 != ch2) {
                    Set<Character> set = new HashSet<Character>();
                    if (map.containsKey(ch1) == true) {
                        set = map.get(ch1);
                        if (set.contains(ch2) == false) {
                            set.add(ch2);
                            indegree.put(ch2, indegree.get(ch2) + 1);
                            map.put(ch1, set);
                        }
                    } else {
                        set.add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                        map.put(ch1, set);
                    }
                    flag = true;
                    break;
                }
            }
            if (flag == false && curr.length() > next.length()) {
                return "";
            }
        }
        LinkedList<Character> queue = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        for (Character ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.addLast(ch);
            }
        }
        int count = 0;
        while (queue.size() > 0) {
            char rem = queue.removeFirst();
            sb.append(rem);
            count++;
            if (map.containsKey(rem) == true) {
                Set<Character> nbrs = map.get(rem);
                for (Character nbr : nbrs) {
                    indegree.put(nbr, indegree.get(nbr) - 1);
                    if (indegree.get(nbr) == 0) {
                        queue.addLast(nbr);
                    }
                }
            }
        }
        if (count == indegree.size()) {
            return sb.toString();
        } else
            return "";
    }
}
