class Solution {
    private boolean countDigits(int num){
        int digitCount = (int)Math.log10(num)+1;
        return digitCount%2 == 0;
    }
    
    public int findNumbers(int[] nums) {
        int count = 0; 
        for(int i=0; i<nums.length; i++){
            if(countDigits(nums[i])){
                count++;
            }
        }
        return count;
    }
}