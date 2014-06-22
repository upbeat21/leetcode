public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] helper = new int[prices.length];
        helper[0] = 0;
        int max = 0;
        int max1 = 0;
        int lowestPrice = prices[0];
        for(int i=1;i<prices.length;i++) {
            lowestPrice = Math.min(prices[i], lowestPrice);
            max1 = Math.max(max1, prices[i]-lowestPrice);
            helper[i] = max1;
        }
        int highestPrice = prices[prices.length-1];
        int max2 = 0;
        for(int i=prices.length-2;i>=1;i--) {
            highestPrice = Math.max(highestPrice, prices[i]);
            max2 = highestPrice - prices[i];
            max = Math.max(max, max2 + helper[i-1]);
        }
        max = Math.max(max, max1);
        return max;
    }
}
