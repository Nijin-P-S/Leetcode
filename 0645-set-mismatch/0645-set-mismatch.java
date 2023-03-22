class Solution {
    public void swap(int nums[], int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int[] findErrorNums(int[] nums) {
        int ind = 0;
        int[] ans = new int[2];
        while(ind < nums.length){
            if(nums[ind] != ind+1 && nums[ind] != nums[nums[ind]-1]){
                swap(nums, ind, nums[ind]-1);
            }
            else{
                ind++;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                ans[0] = nums[i];
                ans[1] = i+1;
                break;
            }
        }
        return ans;
    }
}