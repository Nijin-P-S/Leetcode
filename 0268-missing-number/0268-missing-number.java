class Solution {
    private void cycleSort(int[] nums){
        int i=0; 
        while(i < nums.length){
            if(nums[i] != i && nums[i] < nums.length){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }
    }
    public int missingNumber(int[] nums) {
        cycleSort(nums);
        for(int i=0; i<nums.length; i++){
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }
}