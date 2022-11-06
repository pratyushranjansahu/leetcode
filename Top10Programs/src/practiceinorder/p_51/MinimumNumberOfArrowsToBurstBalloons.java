package practiceinorder.p_51;

import java.util.Arrays;

/*
    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
    https://www.youtube.com/watch?v=Z9o-lqwgSWA
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points)); // 2
    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 1, end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrow++;
                end = points[i][1];
            }
        }
        return arrow;
    }
}
