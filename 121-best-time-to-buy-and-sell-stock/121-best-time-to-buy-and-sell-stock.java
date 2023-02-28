class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 0, profit = 0;
        
        while(right < prices.length){
            if(prices[left] > prices[right])
                left = right;
            
            profit = Math.max(profit, prices[right]-prices[left]);
            right++;
        }
        return profit;
    }
}