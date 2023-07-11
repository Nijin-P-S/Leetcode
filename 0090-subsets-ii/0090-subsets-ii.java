class Solution {
    private void getAllUniqueSubsets(int[] nums, int ind, List<List<Integer>> ans, List<Integer> cur, HashSet<List<Integer>> uni){
        if(ind == nums.length)
        {
            if(!uni.contains(cur)){
                ans.add(new ArrayList<>(cur));
                uni.add(cur);
            }
            
            return;
        }
        
        for(int i=ind; i<nums.length; i++){
            if(i != ind && nums[i] == nums[ind])
                continue;
            getAllUniqueSubsets(nums, i+1, ans, cur, uni);
            cur.add(nums[i]);
            getAllUniqueSubsets(nums, i+1, ans, cur, uni);
            cur.remove(cur.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        HashSet<List<Integer>> uni = new HashSet<>();
        getAllUniqueSubsets(nums, 0, ans, cur, uni);
        return ans;
    }
}