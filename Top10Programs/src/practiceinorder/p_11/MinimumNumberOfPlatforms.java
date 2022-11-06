package practiceinorder.p_11;

import java.util.Arrays;
/*
    GFG : https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    youtube : https://www.youtube.com/watch?v=FkJZlZHWUyk
 */
public class MinimumNumberOfPlatforms {
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;
        System.out.println(findPlatform(arr, dep, n));

    }
    private static int findPlatform(int arr[], int dep[], int n){
        //Sort arrival and departure
        Arrays.sort(arr);
        Arrays.sort(dep);

        //Maintain max train a particular time
        int i = 0;// pointing to arrival time
        int j = 0;// pointing to departure time

        int maxTrain = 0;
        int platform = 0;

        while (i < n && j < n){
            if(arr[i] <= dep[j]){
                maxTrain++;
                i++;
            }else {
                maxTrain--;
                j++;
            }
            platform = Math.max(platform,maxTrain);
        }
        return platform;
    }
}
