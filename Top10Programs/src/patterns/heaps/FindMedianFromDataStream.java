package patterns.heaps;

import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/find-median-from-data-stream/
    https://www.youtube.com/watch?v=YrnkNkPimZc
    https://www.youtube.com/watch?v=_T2JmeMncW0
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;
    private int totalNum = 0;
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> (b-a));
        minHeap = new PriorityQueue<Integer>((a,b) -> (a-b));
    }

    public void addNum(int num) {
        if(!minHeap.isEmpty()){
            if(minHeap.peek() < num){
                minHeap.add(num);
            }else {
                maxHeap.add(num);
            }
        }else {
            maxHeap.add(num);
        }
        totalNum++;

        if(totalNum %2 == 0){
            if (maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }else if (minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }else {
            if (maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }else if (minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (totalNum % 2 == 0){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }
        return (double)maxHeap.peek();
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
