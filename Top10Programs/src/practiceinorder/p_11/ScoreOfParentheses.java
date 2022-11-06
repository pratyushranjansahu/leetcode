package practiceinorder.p_11;

import java.util.Stack;
/*
    https://leetcode.com/problems/score-of-parentheses/
    https://www.youtube.com/watch?v=rWsv46ME6lI
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        //String s = "(())";
        String s = "()";
        System.out.println(scoreOfParentheses(s)); //2
    }

    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(-1);
            }else {
                if(stack.peek() == -1) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int val = 0;
                    while (stack.peek() != -1) {
                        val += stack.pop();
                    }
                    stack.pop();
                    stack.push(2*val);
                }
            }
        }

        int val = 0;
        while (stack.size() > 0) {
            val += stack.pop();
        }
        return val;
    }
}
