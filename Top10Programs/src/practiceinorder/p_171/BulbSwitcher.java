package practiceinorder.p_171;
/*
    https://leetcode.com/problems/bulb-switcher/
    https://www.youtube.com/watch?v=28fXTziUyyk
 */
public class BulbSwitcher {

    public static void main(String[] args) {
        int n = 20;
        System.out.println(bulbSwitch(n));
    }
    public static int bulbSwitch(int n) {
        int count = 0;
        for(int i=1 ; i*i <=n ; i++)
            count++;
        return count;
    }

}
