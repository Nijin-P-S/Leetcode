class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        
        int low = intervals[0][0];
        int high = intervals[0][1];
        int p = 1;
        
        while(p < intervals.length){
            if(intervals[p][0] > high){
                List<Integer> cur = new ArrayList<>();
                cur.add(low);
                cur.add(high);
                res.add(cur);
                low = intervals[p][0];
                high = intervals[p][1];
            }
            else{
                high = Math.max(high, intervals[p][1]);
                low = Math.min(low, intervals[p][0]);
            }
            p++;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(low);
        cur.add(high);
        res.add(cur);
        
        int[][] ans = new int[res.size()][2];
        
        int ind = 0;
        for(List<Integer> a : res){
            ans[ind][0] = a.get(0);
            ans[ind][1] = a.get(1);
            ind++;
        }
        return ans;
    }
}