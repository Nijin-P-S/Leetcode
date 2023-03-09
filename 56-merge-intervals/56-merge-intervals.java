class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null){
            return res.toArray(new int[0][2]);
        }
        
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        
        int low = intervals[0][0];
        int high = intervals[0][1];
        int p = 1;
        
        while(p < intervals.length){
            if(intervals[p][0] > high){
                res.add(new int[]{low, high});
                low = intervals[p][0];
                high = intervals[p][1];
            }
            else{
                high = Math.max(high, intervals[p][1]);
            }
            p++;
        }
        
        res.add(new int[]{low, high});
        return res.toArray(new int[0][]);
    }
}