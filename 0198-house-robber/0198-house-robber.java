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
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            dp[i] = -1;
        return rob(nums, nums.length-1, dp);
    }
}