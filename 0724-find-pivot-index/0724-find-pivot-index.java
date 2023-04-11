class Solution {
    public int pivotIndex(int[] nums) {
        int totSum = 0;
        for(int n : nums)
            totSum+=n;
        int curSum = 0;
        for(int i=0; i<nums.length; i++){
            if(curSum == totSum-nums[i]-curSum)
                return i;
            curSum+=nums[i];
        }
        return -1;
    }
}