class Solution {
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void listOfPermuatations(int[] nums, List<List<Integer>> res, int ind){
        if(ind == nums.length-1){
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        
        for(int i=ind; i<nums.length; i++){
            swap(ind, i, nums);
            listOfPermuatations(nums, res, ind+1);
            swap(ind, i, nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        listOfPermuatations(nums, res, 0);
        return res;
    }
}