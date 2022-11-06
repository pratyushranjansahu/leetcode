package practiceinorder.p_51;

import java.util.Stack;
/*
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * https://www.youtube.com/watch?v=P8xYysvjLd0&t=389s
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));//9
    }
    public static int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (String el : tokens) {
            if (isOperator(el)) {
                int el2 = Integer.parseInt(st.pop());
                int el1 = Integer.parseInt(st.pop());
                int ans = 0;

                if (el.equals("*")) {
                    ans = el1 * el2;
                } else if (el.equals("/")) {
                    ans = el1 / el2;
                } else if (el.equals("+")) {
                    ans = el1 + el2;
                } else if (el.equals("-")) {
                    ans = el1 - el2;
                }
                st.push(ans + "");
            } else {
                // operand
                st.push(el);
            }
        }

        return Integer.parseInt(st.peek());
    }

    private static boolean isOperator(String el) {
        if (el.equals("*") || el.equals("+") || el.equals("-")
                || el.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}
