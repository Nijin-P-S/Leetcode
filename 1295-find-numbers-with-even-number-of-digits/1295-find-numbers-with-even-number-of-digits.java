class Solution {
    private boolean countEvenDigits(int num){
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
            if(countEvenDigits(nums[i])){
                count++;
            }
        }
        return count;
    }
}