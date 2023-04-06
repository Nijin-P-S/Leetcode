class Solution {
    private int coinChange(int[] coins, int amount, int ind, int[][] dp){
        if(amount == 0)
            return 0;
        if(ind == 0){
            if(amount % coins[ind]  == 0)
                return amount/coins[ind];
            return 100000007;
        }
        if(dp[ind][amount] != -1)
            return dp[ind][amount];
        int notPick = coinChange(coins, amount, ind-1, dp);
        int pick = Integer.MAX_VALUE;
        
        if(coins[ind] <= amount){
            pick = 1 + coinChange(coins, amount-coins[ind], ind, dp);
        }
        
        return dp[ind][amount] = Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i=0; i<coins.length; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = -1;
            }
        }
        
        int ans = coinChange(coins, amount, coins.length-1, dp);
        
        
        if(ans >= 100000007)
            return -1;
        return ans;
    }
}