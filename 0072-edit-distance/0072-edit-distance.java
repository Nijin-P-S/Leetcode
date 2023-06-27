class Solution {
    private int minDistance(String word1, String word2, int m, int n, int[][] dp){
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        if(dp[m][n] != -1)
            return dp[m][n];
        int ans = Integer.MIN_VALUE;
        if(word1.charAt(m-1) == word2.charAt(n-1))
            ans = minDistance(word1, word2, m-1, n-1, dp);
        else{
            ans = 1 + Math.min(minDistance(word1, word2, m-1, n, dp), Math.min(minDistance(word1, word2, m, n-1, dp), minDistance(word1, word2, m-1, n-1, dp)));
        }
        return dp[m][n] = ans;
    }
    
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++)
                dp[i][j] = -1;
        }
        
        return minDistance(word1, word2, m, n, dp);
    }
}