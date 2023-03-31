class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i=0; i<n; i++)
            dp[i] = 1;
        
        for(int i=1; i<m; i++){
            int cur[] = new int[n];
            cur[0] = 1;
            for(int j=1; j<n; j++){
                int top = dp[j];
                int left = cur[j-1];
                cur[j] = top+left;
            }
            dp = cur;
        }
        return dp[n-1];
    }
}