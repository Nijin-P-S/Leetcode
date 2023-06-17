class Solution {
    private int digSum(int num){
        int sum = 0;
        while(num > 0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    
    public int differenceOfSum(int[] nums) {
        int eleSum = 0, digiSum = 0;
        
        for(int i : nums){
            digiSum+=digSum(i);
            eleSum+=i;
        }
        return Math.abs(digiSum-eleSum);
    }
}