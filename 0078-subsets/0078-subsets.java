class Solution {
    private void getAll(int[] nums,  List<List<Integer>> ans, List<Integer> cur, int ind){
        if(ind >= nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[ind]);
        getAll(nums, ans, cur, ind+1);
        cur.remove(cur.size()-1);
        
        int i = ind+1;
        while(i<nums.length && nums[i] == nums[i-1])
            i++;
        getAll(nums, ans, cur, i);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        getAll(nums, ans, cur, 0);
        return ans;
    }
}