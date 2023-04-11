class Solution {
    public int[] sortedSquares(int[] nums) {
       int[] ans = new int[nums.length];
        int left = 0, right = nums.length-1;
        int ind = nums.length-1;
        while(left <= right){
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right]*nums[right];
            
            if(leftSq > rightSq){
                ans[ind--] = leftSq;
                left++;
            }
            else{
                ans[ind--] = rightSq;
                right--;
            }
        }
        return ans;
    }
}