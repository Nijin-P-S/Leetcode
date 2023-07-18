class Solution {
    public int arraySign(int[] nums) {
        long product = 1;
        
        for(int num : nums)
           product = ((product%1000000007) * (num%1000000007))%1000000007;
        
        return product == 0? 0:product<0?-1:1;
        
    }
}