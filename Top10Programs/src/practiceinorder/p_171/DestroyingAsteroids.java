package practiceinorder.p_171;

import java.util.Arrays;
/*
    https://leetcode.com/problems/destroying-asteroids/description/
    https://www.youtube.com/watch?v=94UXFl8rGmI
 */
public class DestroyingAsteroids {

    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3,9,19,5,21};
        System.out.println(asteroidsDestroyed(mass, asteroids));//true
    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int as : asteroids){
            if(m < as){
                return false;
            }else{
                m += as;
            }
        }
        return true;
    }
}
