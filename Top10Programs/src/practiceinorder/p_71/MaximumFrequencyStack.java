package practiceinorder.p_71;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * https://leetcode.com/problems/maximum-frequency-stack/
 * https://www.youtube.com/watch?v=KVg4Y0sI4Iw
 */
public class MaximumFrequencyStack {
    Map<Integer, LinkedList<Integer>> stMap;
    Map<Integer,Integer> frequencyMap;
    int maxFrequency;
    public MaximumFrequencyStack() {
        stMap = new HashMap();
        frequencyMap = new HashMap<Integer, Integer>();
        maxFrequency = 0;
    }

    public void push(int val) {
        int currFrequency = frequencyMap.getOrDefault(val, 0);
        currFrequency++;
        frequencyMap.put(val, currFrequency);
        if (stMap.containsKey(currFrequency) == false) {
            stMap.put(currFrequency, new LinkedList<Integer>());
        }
        stMap.get(currFrequency).addFirst(val);
        maxFrequency = Math.max(maxFrequency, currFrequency);
        System.out.println("Push : "+val);
    }


    public int pop() {
        int ans = stMap.get(maxFrequency).removeFirst();
        int currFrequency = frequencyMap.get(ans);
        currFrequency--;
        frequencyMap.put(ans, currFrequency);
        if (stMap.get(maxFrequency).size() == 0) {
            maxFrequency--;
        }
        System.out.println("Pop : "+ans);
        return ans;
    }
    public static void main(String[] args) {

        MaximumFrequencyStack obj = new MaximumFrequencyStack();
        obj.push(5);obj.push(7);obj.push(5);
        obj.push(7);obj.push(4);obj.push(5);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
    }
}
