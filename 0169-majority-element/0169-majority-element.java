class Solution {
    public int majorityElement(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == ans){
                count++;
            }
            else if(count == 0){
                ans = nums[i];
            }
            else{
                count--;
            }
        }
        return ans;
    }
}