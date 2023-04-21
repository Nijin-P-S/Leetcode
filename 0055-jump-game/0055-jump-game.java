class Solution {
    public boolean canJump(int[] nums, int ind, int[] dp){
        if(ind > nums.length-1)
            return false;
        if(ind == nums.length-1)
            return true;
        
        if(dp[ind] != -1){
            return dp[ind] == 1? true : false;
        }
        
        boolean can = false;
        int pos = nums[ind];
        
        for(int i=1; i<=pos; i++){
            can = can || canJump(nums, ind+i, dp);
        }
        dp[ind] = can == true?1:0;
        return can;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp[i] = -1;
        }
        return canJump(nums, 0, dp);
    }
}