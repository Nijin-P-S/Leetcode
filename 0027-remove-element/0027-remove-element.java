class Solution {
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        
        for(; right< nums.length; right++){
            if(nums[right] != val){
                swap(nums, left, right);
                left++;
            }
            while(left <= right && nums[left] != val)
                left++;
        }
        return left;
    }
}