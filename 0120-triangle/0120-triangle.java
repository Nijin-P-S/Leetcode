class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int col = triangle.get(n-1).size();
        int[][] dp = new int[n][col];
        for(int i=0; i<col; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        } 
        for(int i = n-2; i>=0 ; i--){
            for(int j=0; j<=i; j++){
                int bot = dp[i+1][j] + triangle.get(i).get(j);
                int dg = dp[i+1][j+1]+ triangle.get(i).get(j);
                dp[i][j] = Math.min(bot, dg);
            }
        }
        return dp[0][0];
    }
}