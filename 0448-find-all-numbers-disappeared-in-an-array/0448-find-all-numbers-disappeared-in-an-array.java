class Solution {
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();  
        int ind = 0;
        while(ind < nums.length){
            if(nums[ind] != ind+1 && nums[nums[ind]-1] != nums[ind]){
                swap(nums, nums[ind]-1, ind);
            }
            else{
                ind++;
            }
        }
        for(int i=1; i<=nums.length; i++){
            if(nums[i-1] != i)
                ans.add(i);
        }
        return ans;
    }
}