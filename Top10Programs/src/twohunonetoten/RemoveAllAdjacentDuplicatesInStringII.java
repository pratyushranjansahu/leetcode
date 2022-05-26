package twohunonetoten;

import java.util.Stack;
/*
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
    https://www.youtube.com/watch?v=RJpy4A7LJrs
    https://www.youtube.com/watch?v=w6LcypDgC4w
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s,k));//aa
    }
    public static String removeDuplicates(String s, int k) {
        Stack<int[]> main = new Stack<>();

        for(char c: s.toCharArray()){
            if(!main.isEmpty() && main.peek()[0] == c){
                main.peek()[1]++;
            }
            else{
                main.push(new int[]{c,1});
            }

            if(main.peek()[1]==k){
                main.pop();
            }
        }

        StringBuilder sb= new StringBuilder();

        while(!main.isEmpty()){
            int[] top = main.pop();

            while(top[1]-->0)
                sb.append((char) top[0]);
        }

        return sb.reverse().toString();
    }
}
