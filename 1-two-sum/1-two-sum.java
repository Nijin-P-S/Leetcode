class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> ele = new HashMap<>();
        
        for(int i=0; i<nums.length ; i++){
            if(ele.get(target-nums[i]) != null){
                return new int[]{i, ele.get(target-nums[i])};
            }
            ele.put(nums[i],i);
        }
        return new int[2];
    }
}