class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        int left = 0, right = 0;
        
        while(right < prices.length){
            if(prices[left] > prices[right]){
                left = right;
            }
            else{
                profit += (prices[right] - prices[left]);
                left = right;
            }
            right++;
        }
        return profit;
    }
}