package practiceinorder.p_1;
/*
    https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/description/
    https://www.youtube.com/watch?v=Pk128gC_sdw&t=1043s
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public static void main(String[] args) {
        int n = 5;
        int[] ranges = {3,4,1,1,0,0};
        System.out.println(minTaps(n,ranges));//1
    }
    public static int minTaps(int n, int[] ranges) {
        int min = 0;
        int max = 0;
        int open = 0;
        int index = 0;
        while(max<n){ //10

            for(int i=index;i<ranges.length;i++){
                if(i-ranges[i]<=min && i+ranges[i]>max){
                    max = i+ranges[i];
                    index = i;
                }
            }
            if(min==max)return -1;
            open++;
            min = max;
        }

        return open;
    }
}
