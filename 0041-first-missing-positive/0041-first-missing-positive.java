class Solution {
    public void swap(int nums[], int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        
        int ind = 0;
        while(ind < nums.length){
            if(nums[ind] <= 0 || nums[ind] > nums.length){
                ind++;
                continue;
            }
            else if(nums[ind] != ind+1 && nums[ind] != nums[nums[ind]-1]){
                swap(nums, ind, nums[ind]-1);
            }
            else{
                ind++;
            }
        }
       
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
}