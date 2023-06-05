class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int maxInd = -1, minInd = -1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                minInd = i;
            }
            if(nums[i] == nums.length)
                maxInd = i;
        }
        
        if(minInd > maxInd){
            return (nums.length-1-maxInd) + (minInd-1);
        }
        else{
            return (nums.length-1-maxInd) + (minInd);
        }
    }
}