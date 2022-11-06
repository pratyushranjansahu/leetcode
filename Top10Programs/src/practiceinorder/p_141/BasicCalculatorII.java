package practiceinorder.p_141;

import java.util.Stack;
/*
 * https://leetcode.com/problems/basic-calculator-ii/
 * https://www.youtube.com/watch?v=gmy6L9vHTbo
 */
public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));//7
    }
    public static int calculate(String s) {
        Stack<Integer> stack =new Stack();
        int n = s.length();
        char sign = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                if (sign == '+') {
                    stack.push(val);
                }else if (sign == '-') {
                    stack.push(-val);
                }else if (sign == '*') {
                    int a = stack.pop();
                    int ans = a * val;
                    stack.push(ans);
                }else if (sign == '/') {
                    int a = stack.pop();
                    int ans = a / val;
                    stack.push(ans);
                }
            }else if (ch != ' ') {
                sign = ch;
            }

        }
        int sum = 0;
        while (stack.size() > 0) {
            sum +=stack.pop();

        }
        return sum;
    }
}

