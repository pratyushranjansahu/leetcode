package patterns.dynamicprogramming;

/*
  https://leetcode.com/problems/solving-questions-with-brainpower/
  https://www.youtube.com/watch?v=eQLebxwB5GM
 */
public class SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        int[][] arr = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoints(arr));//5
    }
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] points = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            points[i] = questions[i][0];

            int next = i + questions[i][1] + 1;

            if (next < n) {
                points[i] = Math.max(
                        points[i] + points[next], // ✅ add only once
                        points[i + 1]
                );
            } else if (i + 1 < n) {
                points[i] = Math.max(points[i], points[i + 1]);
            }
        }

        return points[0];
    }
}
