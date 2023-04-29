class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        dp1[0] = nums[0];
        dp2[1] = nums[1];
        
        for(int i=1; i<nums.length-1; i++){
            int pick = i>1 ? nums[i] + dp1[i-2] : dp1[i-1];
            int notPick = dp1[i-1];
            dp1[i] = Math.max(pick, notPick);
        }
        
        for(int i=2; i<nums.length; i++){
            int pick = nums[i] + dp2[i-2];
            int notPick = dp2[i-1];
            dp2[i] = Math.max(pick, notPick);
        }
        return Math.max(dp1[nums.length-2], dp2[nums.length-1]);
    }
}