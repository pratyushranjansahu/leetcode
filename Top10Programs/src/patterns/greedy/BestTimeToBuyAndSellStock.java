package patterns.greedy;
/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    https://www.youtube.com/watch?v=41FBv9Jpjcs
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices)); // 5
    }
    public static int maxProfit(int[] prices) {
        if(prices.length==0)return 0;

        int min = prices[0];
        int maxProf = 0;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            maxProf = Math.max(maxProf,prices[i]-min);
        }

        return maxProf;
    }
}
