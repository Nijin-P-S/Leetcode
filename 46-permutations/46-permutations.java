class Solution {
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void listOfPermuatations(int[] nums, List<Integer> cur, List<List<Integer>> res, int ind){
        if(ind == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=ind; i<nums.length; i++){
            swap(ind, i, nums);
            cur.add(nums[ind]);
            listOfPermuatations(nums, cur, res, ind+1);
            cur.remove(cur.size()-1);
            swap(ind, i, nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
         List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        listOfPermuatations(nums, cur, res, 0);
        return res;
    }
}