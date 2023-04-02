class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int col = triangle.get(n-1).size();
        int[] front = new int[col];
        
        for(int i=0; i<col; i++){
            front[i] = triangle.get(n-1).get(i);
        } 
        for(int i = n-2; i>=0 ; i--){
            int[] cur = new int[n];
            for(int j=0; j<=i; j++){
                int bot = front[j] + triangle.get(i).get(j);
                int dg = front[j+1]+ triangle.get(i).get(j);
                cur[j] = Math.min(bot, dg);
            }
            front = cur;
        }
        return front[0];
    }
}