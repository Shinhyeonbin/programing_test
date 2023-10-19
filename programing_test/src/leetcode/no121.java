package leetcode;

public class no121 {
	public static int maxProfit(int[] prices) {
		int buy = prices[0];
		int profit = 0;
		
		for(int i = 1; i < prices.length; i++) {
			if(buy > prices[i]) {
				buy = prices[i];
			}
			if(profit < (prices[i] - buy)) {
				profit = prices[i] - buy;
			}	
		}
		return profit;
		
	}
	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 6, 4};
		int A = maxProfit(arr);
		
		System.out.println(A);
		
	}

}
