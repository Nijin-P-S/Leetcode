class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(freq.get(nums[i]) == null){
                freq.put(nums[i], 0);
            }
            freq.put(nums[i], freq.get(nums[i])+1);
        }
        
        HashSet<Integer> uniFreq = new HashSet<>();
        for(int val : freq.values())
            uniFreq.add(val);
        
        PriorityQueue<Integer> mxHp = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : uniFreq)
            mxHp.add(val);
        
        HashMap<Integer, List<Integer>> freqKeyMap = new HashMap<>();
        
        for(int key : freq.keySet()){
            int val = freq.get(key);
            if(freqKeyMap.get(val) == null)
                freqKeyMap.put(val, new ArrayList<>());
            List<Integer> cur = freqKeyMap.get(val);
            cur.add(key);
            freqKeyMap.put(val, cur);
        }
        
        int[] ans = new int[k];
        
        while(k>0){
            int f = mxHp.poll();
            List<Integer> cur = freqKeyMap.get(f);
            
            for(int num : cur){
                 ans[k-1] = num;
                 k--;
                if(k <= 0)
                    break;
            }
        }
        return ans;
    }
}