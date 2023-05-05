class Solution {
    public int maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> ans = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums)
            ans.add(num);
        int out = 0;
        while(k-- > 0){
            int poll = ans.poll();
            out+=poll;
            ans.add(poll+1);
        }
        return out;
    }
}