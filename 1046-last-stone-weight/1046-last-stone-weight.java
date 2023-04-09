class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHp = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int s : stones)
            maxHp.add(s);
        
        while(maxHp.size() > 1){
            int frst = maxHp.poll();
            int scnd = maxHp.poll();
            
            if(frst != scnd)
                maxHp.add(frst-scnd);
        }
        if(maxHp.size() == 0)
            return 0;
        return maxHp.peek();
    }
}