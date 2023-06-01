class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0] > target)
            return 0;
        if(nums[nums.length-1] < target)
            return nums.length;
        int min = Integer.MIN_VALUE;
        int left = 0, right = nums.length-1;
        
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target){
                right = mid-1;
            }
            else{
                min = Math.max(min, mid);
                left = mid+1;
            }
        }
        return min+1;
    }
}