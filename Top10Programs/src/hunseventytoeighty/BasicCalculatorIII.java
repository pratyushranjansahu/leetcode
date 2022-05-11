package hunseventytoeighty;

import java.util.Stack;
/*
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/stacks/basic-calculator-3-official/ojquestion
 * https://www.youtube.com/watch?v=s_EKZnQUOp0&t=1445s
 */
public class BasicCalculatorIII {
    public static void main(String[] args) {
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(calculate(s));//21
    }
    public static int calculate(String s) {
        Stack<Pair> stackPairs = new Stack();
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
                calc(stack,val,sign);

            }else if (ch == '(') {
                stackPairs.push(new Pair(stack, sign));
                sign = '+';
                stack =new Stack();
            }else if (ch == ')') {
                int val = 0;
                while (stack.size() > 0) {
                    val += stack.pop();
                }
                Pair p = stackPairs.pop();
                stack = p.stack;
                sign = p.sign;
                calc(stack,val,sign);

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
    public static void calc(Stack<Integer> stack, int val, char sign) {
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
    }
    static class Pair {
        Stack<Integer> stack;
        char sign;
        Pair(Stack<Integer> stack, char sign) {
            this.stack = stack;
            this.sign = sign;
        }
    }
}
