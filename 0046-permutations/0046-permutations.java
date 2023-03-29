class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void permute(int[] nums, int ind, List<List<Integer>> ans, List<Integer> cur){
        if(ind == nums.length-1){
            cur.add(nums[ind]);
            ans.add(new ArrayList<>(cur));
            cur.remove(cur.size()-1);
            return;
        }
        
        for(int i=ind; i<nums.length; i++){
            swap(nums, ind, i);
            cur.add(nums[ind]);
            permute(nums, ind+1, ans, cur);
            cur.remove(cur.size()-1);
            swap(nums, ind, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        permute(nums, 0, ans, cur);
        return ans;
    }
}