class Solution {
    private boolean helper(int[] nums, int ind, int target, int[][] dp){
        if(target == 0)
            return true;
        if(ind == 0)
            return nums[ind] == target;
        
        if(dp[ind][target] != -1)
            return dp[ind][target] == 1? true : false;
        
        boolean notPick = helper(nums, ind-1, target, dp);
        boolean pick = false;
        if(nums[ind] <= target){
            pick = helper(nums, ind-1, target-nums[ind], dp);
        }
        
        dp[ind][target] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }
    private boolean canPartition(int[] nums, int ind, int target)
    {
        int[][] dp = new int[nums.length][target+1];
        
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<=target; j++)
                dp[i][j] = -1;
        }
        
        return helper(nums, ind, target, dp);
        
    }
    public boolean canPartition(int[] nums) {
        if(nums.length == 1 && nums[0] != 0)
            return false;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum % 2 != 0)
            return false;
        
        return canPartition(nums, nums.length-1, sum/2);
    }
}