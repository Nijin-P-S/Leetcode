class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int findDuplicate(int[] nums) {
        int left = 0;
        
        while(left < nums.length){
            if(nums[left] == left+1){
                left++;
            }
            else{
                if(nums[nums[left]-1] == nums[left]){
                    return nums[left];
                }
                else{
                    swap(nums, left, nums[left]-1);
                }
            }
        }
        return -1;
    }
}