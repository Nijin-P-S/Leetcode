class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        
        if(intervals == null || intervals.length == 0){
            return ans.toArray(new int[0][2]);
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int low = intervals[0][0];
        int high = intervals[0][1];
        int p = 1;
        
        while(p < intervals.length){
            if(intervals[p][0] > high){
                ans.add(new int[]{low, high});
                low = intervals[p][0];
                high = intervals[p][1];
            }
            else{
                high = Math.max(high, intervals[p][1]);
            }
            p++;
        }
        ans.add(new int[]{low, high});
        return ans.toArray(new int[0][]);
    }
}