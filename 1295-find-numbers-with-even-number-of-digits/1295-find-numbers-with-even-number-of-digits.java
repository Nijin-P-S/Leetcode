class Solution {
    private boolean countDigits(int num){
        int digitCount = (int)Math.log10(num)+1;
        return digitCount%2 == 0;
    }
    private boolean countEvenDigits(int num){
        if(num == 0)
            return false;
        if(num < 0){
            num=num*-1;
        }
        int count= 0;
        while(num > 0){
            count++;
            num/=10;
        }
        return count%2==0;
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