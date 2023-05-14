package practiceinorder.p_171;
/*
    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/stacks/design-hit-counter-official/ojquestion
    https://www.geeksforgeeks.org/design-a-hit-counter/
 */
public class DesignHitCounter {

    static int[] times = new int[300];
    static int[] hits = new int[300];

    public static void main(String[] args) {
            hit(1);
            //hit(300);
            hit(301);
        System.out.println(getHits(300));
        for (int time : times){
            //System.out.println(time);
        }
    }
    static void hit(int timestamp)
    {
        int idx = timestamp % 300;
        if (times[idx] != timestamp) {
            times[idx] = timestamp;
            hits[idx] = 1;
        }
        else {
            ++hits[idx];
        }
    }

    static int getHits(int timestamp)
    {
        int res = 0;
        for (int i = 0; i < 300; ++i) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }
}
