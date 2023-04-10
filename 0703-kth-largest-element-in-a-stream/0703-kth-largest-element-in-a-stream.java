class KthLargest {
    PriorityQueue<Integer> minHeap ;
    int size = 0;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        size = k;
        for(int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
        }
        
        while(minHeap.size() > size)
            minHeap.poll();
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size() > size)
            minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */