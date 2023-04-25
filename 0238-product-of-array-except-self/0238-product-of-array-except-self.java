class Solution {
    public int[] productExceptSelf(int[] nums) {
        HashSet<Integer> zeros = new HashSet<>();
        
        int[] ans = new int[nums.length];
        int pro = 1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)
                pro*=nums[i];
            else{
                zeros.add(i);
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                if(zeros.size() == 0)
                    ans[i] = pro/nums[i];
                else
                    ans[i] = 0;
            }
            else{
                if(zeros.size() > 1)
                    ans[i] = 0;
                else
                    ans[i] = pro;
            }
        }
        return ans;
    }
}