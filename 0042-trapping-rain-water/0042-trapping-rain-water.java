class Solution {
    public int trap(int[] height) {
        int length = height.length;
        
        int[] prefixMax = new int[length];
        int[] suffixMax = new int[length];
        
        int max = 0;
        for(int i=0; i<length; i++){
            prefixMax[i] = Math.max(max, height[i]);
            max = Math.max(max, height[i]);
        }
        max = 0;
        for(int i=length-1; i>=0; i--){
            suffixMax[i] = Math.max(max, height[i]);
            max = Math.max(max, height[i]);
        }
        
        int ans = 0;
        
        for(int i=0; i<length; i++){
            ans += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        
        return ans;
    }
}