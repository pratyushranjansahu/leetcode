package hunseventytoeighty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/celebrity-problem-official/ojquestion
 * https://www.youtube.com/watch?v=CiiXBvrX-5A
 */
public class FindTheCelebrety {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }
    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position),
        // if there is not then print "none"
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }

        int pot = st.pop();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(pot);
        } else {
            System.out.println("none");
        }
    }
}
