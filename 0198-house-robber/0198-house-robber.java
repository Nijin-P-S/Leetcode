class Solution {

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