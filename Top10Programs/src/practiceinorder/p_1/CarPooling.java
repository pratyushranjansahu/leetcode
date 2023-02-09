package practiceinorder.p_1;
//https://www.youtube.com/watch?v=nO95uYKB-lo
//Leetcode : 1094
public class CarPooling {
    public static void main(String[] args) {
        //int[][] trips = {{1,5,2},{4,8,1},{11,15,3}}; int capacity = 3;(youtube example .som changed in index)
        int[][] trips = {{2,1,5},{3,3,7}}; int capacity = 4;
       // int[][] trips = {{9,0,1},{3,3,7}}; int capacity = 4;


        System.out.println(carPooling(trips, capacity));
    }



    public static boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for(int[] trip : trips){
            max = Math.max(max,trip[2]);
        }
        int[] highWay = new int[max+1];

        for(int[] trip : trips){
            highWay[trip[1]] += trip[0];
            highWay[trip[2]] -= trip[0];
        }

        if(highWay[0] > capacity)
            return false;
        for(int i = 1; i< highWay.length;i++){
            highWay[i] += highWay[i-1];
            if(highWay[i] > capacity)
                return false;

        }

        return true;
    }
}
