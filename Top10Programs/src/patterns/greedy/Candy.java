package patterns.greedy;

import java.util.Arrays;
/*
  https://leetcode.com/problems/candy/description/
  https://www.youtube.com/watch?v=PzBYQA6FshA
 */
public class Candy {
    public static void main(String[] args) {
        int[] arr = {1,0,2};
        System.out.println(candy(arr));//5
    }
    private static int candy(int[] ratings) {
        int n =ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i = 1; i < n; i++){
            if( ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        for(int i = n-2; i >= 0; i--){
            if( ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            int max = Math.max(left[i],right[i]);
            res += max;
        }
        return res;

    }
}
