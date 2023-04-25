class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        
        int[] ans = new int[nums.length];
        int pro = 1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)
                pro*=nums[i];
            else{
                zeroCount++;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                if(zeroCount == 0)
                    ans[i] = pro/nums[i];
                else
                    ans[i] = 0;
            }
            else{
                if(zeroCount > 1)
                    ans[i] = 0;
                else
                    ans[i] = pro;
            }
        }
        return ans;
    }
}