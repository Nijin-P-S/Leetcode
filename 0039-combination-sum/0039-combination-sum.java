class Solution {
    private void getAll(int[] candidates, int target, int sum, int ind, HashSet<List<Integer>> ans, List<Integer> cur){
        if(ind == candidates.length){
            if(sum == target){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        getAll(candidates, target, sum, ind+1, ans, cur);
        
        for(int i=ind; i<candidates.length; i++){
            if(sum+candidates[ind] <= target){
                cur.add(candidates[ind]);
                getAll(candidates, target, sum+candidates[ind], i, ans, cur);
                cur.remove(cur.size()-1);
            }
        }
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        getAll(candidates, target, 0, 0, set, cur);
        
        for(List<Integer> ele : set){
            ans.add(ele);
        }
        return ans;
    }
}