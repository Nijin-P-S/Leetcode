class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Double> unique = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums){
            minHeap.add(num);
            maxHeap.add(num);
        }
        
        while(!minHeap.isEmpty() && !maxHeap.isEmpty()){
            int first = minHeap.poll();
            int second = maxHeap.poll();
            unique.add((first+second)/2.0);
        }
        
        return unique.size();
    }
}