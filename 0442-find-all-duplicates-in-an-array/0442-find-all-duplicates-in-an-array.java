class Solution {
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public List<Integer> findDuplicates(int[] nums) {
        int ind = 0;
        
        while(ind < nums.length){
            if(nums[ind] != ind+1 && nums[nums[ind]-1] != nums[ind]){
                swap(nums, ind, nums[ind]-1);
            }
            else{
                ind++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(ind = 0; ind<nums.length; ind++){
            if(nums[ind] != ind+1)
                ans.add(nums[ind]);
        }
        return ans;
    }
}