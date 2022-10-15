package hundreadtwintyonetothirty;

import java.util.Arrays;
import java.util.PriorityQueue;
//https://stackoverflow.com/questions/40992062/reduce-array-by-adding-elements
//Given an array, reduce the array to a single element with minimum cost. For reducing, remove two elements from the array, add those two numbers and keep the sum back in the array. The cost of each operation is the sum of the elements removed in that step.
public class ReduceArrayByAddingElements {

	public static void main(String[] args) {
		//Integer[] arr= {1,2,3,};
		//Integer[] arr= {4,6,8};
		
		Integer[] arr= {5,4,6};
		//Integer[] arr= {3,2,1,10};
		System.out.println(sumAndCost(arr));

	}  
	
	public static int sumAndCost(Integer[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(arr));
        int sum = priorityQueue.poll();
        int cost = 0;
        while (!priorityQueue.isEmpty()) {
            int currentElement = priorityQueue.poll();
            if (currentElement < sum) {
                priorityQueue.add(sum);
                sum = currentElement;
            } else {
                sum += currentElement;
                cost += sum;
                continue;
            }

            sum += priorityQueue.poll();
            cost += sum;
        }

        return  cost;
    }

}
