class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = 0;
        while(left < right){
            int curArea = (right-left) * Math.min(height[left], height[right]);
            max = Math.max(max, curArea);
            if(height[left] > height[right]){
                right--;
            }
            else if(height[right] > height[left]){
                left++;
            }
            else{
                left++;
                right--;
            }
        }
        return max;
    }
}