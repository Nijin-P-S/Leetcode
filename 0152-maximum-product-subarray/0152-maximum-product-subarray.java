class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int max = 1, min = 1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                ans = Math.max(ans, 0);
                max = 1;
                min = 1;
            }
            else{
                int temp = max;
                max = Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));
                min = Math.min(nums[i], Math.min(nums[i]*temp, nums[i]*min));
                ans = Math.max(ans, max);
            }
        }
        return ans;
    }
}