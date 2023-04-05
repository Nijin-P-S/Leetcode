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
        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i=0; i<nums.length; i++)
            dp[i][0] = true;
        if(nums[0] < dp[0].length)dp[0][nums[0]] = true;
        
        for(int i=1; i<nums.length; i++){
            for(int k = 1; k<=target; k++){
                boolean notPick = dp[i-1][k];
                boolean pick = false;
                if(nums[i] <= k){
                    pick = dp[i-1][k-nums[i]] ;
                }
                dp[i][k] = (pick || notPick);
            }
        }
        
        return dp[nums.length-1][target];
        
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