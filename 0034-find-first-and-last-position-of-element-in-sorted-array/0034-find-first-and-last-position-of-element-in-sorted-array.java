class Solution {
    public int[] searchRange(int[] nums, int target) {
        int reqLeft = -1, reqRight = -1;
        int left = 0, right = nums.length-1;
        
        while(left <= right){
            int mid = left+ (right-left)/2;
            if(nums[mid] >= target)
                right = mid-1;
            else
                left = mid+1;
        }
        reqLeft = left;
        
        left = 0;
        right = nums.length-1;
        while(left <= right){
            int mid = left+ (right-left)/2;
            if(nums[mid] > target)
                right = mid-1;
            else
                left = mid+1;
        }
        reqRight = right;
        
        if(reqLeft > reqRight){
            return new int[]{-1,-1};
        }
        return new int[]{reqLeft, reqRight};
    }
}