class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        
        
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int diff = sum-k;
            
            count+=prefixSum.getOrDefault(diff, 0);
            if(prefixSum.get(sum) == null){
                prefixSum.put(sum, 0);
            }
            prefixSum.put(sum, prefixSum.get(sum)+1);
        }
        return count;
    }
}