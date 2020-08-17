package fortyonetofifty;

public class BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {
		int[] prices= {1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
	
	private static int maxProfit(int[] prices) {
		if(prices.length<=1) return 0;
		int A=0,B=-prices[0],C=0;
		for(int i=1;i<prices.length;i++) {
			int prevA=A;
			A=Math.max(A, C);
			C=B+prices[i];
			B=Math.max(prevA-prices[i], B);
		}
		return Math.max(A, C);
	}

}
