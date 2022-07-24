package patterns.heaps;

import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/find-median-from-data-stream/
    https://www.youtube.com/watch?v=_T2JmeMncW0
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> (b-a));
        minHeap = new PriorityQueue<Integer>((a,b) -> (a-b));
    }

    public void addNum(int num) {
        if(maxHeap.size() == 0 || maxHeap.peek()>=num){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        balance();
    }

    public double findMedian() {
        if(maxHeap.size()> minHeap.size()){
            return maxHeap.peek();
        } else if(maxHeap.size()< minHeap.size()) {
            return minHeap.peek();
        } else{
            // maxHeap == minHeap size
            return (maxHeap.peek()  + minHeap.peek())/2.0;
        }
    }
    private void balance(){
        if(maxHeap.size() - minHeap.size() >1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() - maxHeap.size() >1){
            maxHeap.offer(minHeap.poll());
        }
    }
    public static void main(String[] args) {
        FindMedianFromDataStream obj = new FindMedianFromDataStream();
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(4);
        double param_2 = obj.findMedian();
        System.out.println("Median is : "+param_2);
    }
}
