class Solution {
    // private void swap(int[] nums, int i, int j){
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        int temp = 0;
        while(mid <= high){
            if(nums[mid] == 0){
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
                mid++;
            else if(nums[mid] == 2){
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}