class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void permute(int[] nums, int ind, List<List<Integer>> ans){
        if(ind == nums.length-1){
            List<Integer> cur = new ArrayList<>();
            for(int val : nums){cur.add(val);}
            ans.add(cur);
            return;
        }
        for(int i=ind; i<nums.length; i++){
            swap(nums, ind, i);
            permute(nums, ind+1, ans);
            swap(nums, ind, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0, ans);
        return ans;
    }
}