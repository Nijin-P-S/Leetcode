class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int majFreq = 0;
        
        List<Integer> ans = new ArrayList<>();
        for(int val : nums){
            if(freq.get(val) == null){
                freq.put(val, 0);
            }
            freq.put(val, freq.get(val)+1);
        }
        
        majFreq = (nums.length/3)+1;
        
        for(int key : freq.keySet()){
            if(freq.get(key) >= majFreq){
                ans.add(key);
            }
        }
        return ans;
    }
}