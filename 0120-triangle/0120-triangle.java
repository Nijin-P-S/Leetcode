class Solution {
    private int minTotal(List<List<Integer>> triangle, int n, int ind, int row, int[][] dp){
        if(row == n-1){
            return triangle.get(row).get(ind);
        }
        if(dp[row][ind] != -1)
            return dp[row][ind];
        int min = Integer.MIN_VALUE;
        int bot = minTotal(triangle, n, ind, row+1, dp) + triangle.get(row).get(ind);
        int dg = minTotal(triangle, n, ind+1, row+1, dp)  + triangle.get(row).get(ind);
        
        return dp[row][ind] = min = Math.min(bot, dg);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][triangle.get(n-1).size()];
        for(int i=0; i<n; i++){
            for(int j=0; j<= i; j++)
                dp[i][j] = -1;
        }
        return minTotal(triangle, n, 0, 0, dp);
    }
}