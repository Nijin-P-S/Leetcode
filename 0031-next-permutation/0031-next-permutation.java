class Solution {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        
        
        for(int i=nums.length-1; i>0; i--){
            if(nums[i] > nums[i-1])
            {
                breakPoint = i;
                break;
            }
        }
        int toBeSwapped = -1;
        if(breakPoint != -1){
            for(int i=nums.length-1; i>= breakPoint; i--){
                if(nums[breakPoint-1] < nums[i]){
                    toBeSwapped = i;
                    break;
                }
            }
            if(toBeSwapped != -1){
                int temp = nums[toBeSwapped];
                nums[toBeSwapped] = nums[breakPoint-1];
                nums[breakPoint-1] = temp;
            }
        }
        
        int left = breakPoint != -1 ? breakPoint : 0, right = nums.length-1;
        
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}