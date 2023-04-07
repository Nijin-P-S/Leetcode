class Solution {
    private int rob(int[] nums, int ind, int[] dp){
        if(ind == 0)
            return nums[0];
        
        if(dp[ind] != -1)
            return dp[ind];
        int notPick = rob(nums, ind-1, dp);
        int pick = nums[ind];
        if(ind-2 >= 0)
            pick+=  rob(nums, ind-2, dp);
        
        return dp[ind] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];
        
        for(int i=1; i<nums.length; i++){
            int notPick = prev1;
            int pick = nums[i] + prev2;
            
            prev2 = prev1;
            prev1 = Math.max(pick, notPick);
        }
        return prev1;
    }
}