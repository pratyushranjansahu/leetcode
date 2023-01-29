package practiceinorder.p_131;
/*
 * https://leetcode.com/problems/house-robber/
 * https://www.youtube.com/watch?v=pchOMyPbp0I&t=145s
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Integer[] dp = new Integer[nums.length];
        System.out.println(houseRobber(nums,dp,0));//4
    }
    public static int houseRobber(int[] house,Integer[] dp, int currIdx) {
        if(currIdx >= house.length)
            return 0;
        if(dp[currIdx] != null)
            return dp[currIdx];

        int stealCurrentHouse = house[currIdx] + houseRobber(house,dp,currIdx+2);
        int skipCurrentHouse =  houseRobber(house,dp,currIdx+1);
        return dp[currIdx] = Math.max(stealCurrentHouse,skipCurrentHouse);
    }
}
