package twohunonetoten;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h)); //4
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int val : piles) {
            max = Math.max(max, val);
        }
        if (h == piles.length) {
            return max;
        }
        int lo = 0;
        int hi = max;
        int speed = Integer.MAX_VALUE;
        while (lo <= hi) {
            int sp = lo + (hi - lo)/2;
            if (isPossible(piles, h, sp)) {
                speed = sp;
                hi = sp - 1;
            }else {
                lo = sp +1;
            }
        }
        return speed;
    }
    private static boolean isPossible (int[] piles, int h, int sp) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (int)Math.ceil(piles[i] * 1.0/sp);
        }
        return time <= h;
    }
}
