package hunsixtytoseventy;

import java.util.Arrays;
/*
    https://leetcode.com/problems/car-fleet/
    https://www.youtube.com/watch?v=PemeYPadst4
 */

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(target, position, speed));//3
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int numberOfFleet = 1;
        int n = position.length;
        double[][] carData = new double[n][2];
        for (int i = 0; i < n; i++) {
            carData[i][0] = position[i] * 1d;
            carData[i][1] = ((target-position[i]) * 1d) / speed[i];
        }
        //Arrays.sort(carData, Comparator.comparingDouble(a -> a[0]));
        Arrays.sort(carData, (a,b) -> Double.compare(a[0], b[0]));
        double tt = carData[n-1][1];
        for (int i = n-2; i >=0 ; i--) {
            if (carData[i][1] > tt) {
                numberOfFleet++;
                tt = carData[i][1];
            }
        }
        return numberOfFleet;
    }
}
