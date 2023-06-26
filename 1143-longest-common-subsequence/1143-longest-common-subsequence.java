class Solution {
    // private int longestCommonSubsequence(String s1, String s2, int m, int n, int[][] dp){
    //     if(dp[m][n] != -1)
    //         return dp[m][n];
    //     if(m == 0 || n == 0)
    //         return dp[m][n] = 0;
    //     if(s1.charAt(m-1) == s2.charAt(n-1))
    //         return dp[m][n] = 1 + longestCommonSubsequence(s1, s2, m-1, n-1, dp);
    //     else{
    //         return dp[m][n] = Math.max(longestCommonSubsequence(s1, s2, m-1, n, dp), longestCommonSubsequence(s1, s2, m, n-1, dp));
    //     }
    // }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m ; i++)
            dp[i][0] = 0;
        for(int j=0; j<=n; j++)
            dp[0][j] = 0;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}