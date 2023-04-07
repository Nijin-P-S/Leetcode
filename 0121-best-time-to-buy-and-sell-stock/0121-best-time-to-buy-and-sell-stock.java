class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 0;
        int maxPro = 0;
        while(right < prices.length){
            if(prices[right] < prices[left])
                left = right;
            else
                maxPro = Math.max(maxPro, prices[right] - prices[left]);
            right++;
        }
        return maxPro;
    }
}