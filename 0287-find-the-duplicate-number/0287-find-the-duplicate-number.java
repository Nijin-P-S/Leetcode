class Solution {
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int findDuplicate(int[] nums) {
        int ind = 0; 
        while(ind < nums.length){
            if(nums[ind] != ind+1 && nums[nums[ind]-1] != nums[ind]){
                swap(nums, ind, nums[ind]-1);
            }
            else{
                ind++;
            }
        }
        return nums[nums.length-1];
    }
}