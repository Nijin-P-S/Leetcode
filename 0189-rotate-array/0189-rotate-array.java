class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int d[] = new int[k];
        int ind = 0;
        for(int i=nums.length-k; i<nums.length; i++)
            d[ind++] = nums[i];
        
        ind = 0;
        
        for(int i=nums.length-k-1; i>=0; i--){
            nums[nums.length-ind-1] = nums[i];
            ind++;
        }
        
        for(int i= 0; i<k; i++)
            nums[i] = d[i];
    }
}