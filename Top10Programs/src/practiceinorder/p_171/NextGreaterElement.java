package practiceinorder.p_171;

import java.util.Stack;

/*
	https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
 	https://www.youtube.com/watch?v=rSf9vPtKcmI&t=616s
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        //[1,13,14,5,7,12] -> 13 14 -1 7 12 -1
        long[] arr= {1,13,14,5,7,12};
        long[] ret=nextLargerElement(arr,arr.length);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]+"  "+ret[i]);
        }

    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] res = new long[n];
        Stack<Long> st = new Stack<Long>();
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[i] >= st.peek())
                st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.add(arr[i]);
        }
        return res;
    }
}
