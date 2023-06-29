class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=1; i<=numRows; i++){
            List<Integer> prev = new ArrayList<>();
            if(i != 1)
                prev = res.get(i-2);
            List<Integer> cur = new ArrayList<>();
            
            for(int j=1; j<=i; j++){
                if(j == 1 || j == i)
                    cur.add(1);
                else{
                    cur.add(prev.get(j-2) + prev.get(j-1));
                }
            }
            res.add(cur);
        }
        return res;
    }
}