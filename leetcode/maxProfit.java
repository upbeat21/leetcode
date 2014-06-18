public class Solution {
    public int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
        int lowestPrice = prices[0];
		int result = 0;
		for(int n : prices) {
			if(n < lowestPrice) lowestPrice = n;
			if(n - lowestPrice > result) result = n - lowestPrice;
		}
		return result;
    }
}
