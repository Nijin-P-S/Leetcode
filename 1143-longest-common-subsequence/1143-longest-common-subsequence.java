class Solution {
    private int longestCommonSubsequence(String s1, String s2, int m, int n, int[][] dp){
        if(dp[m][n] != -1)
            return dp[m][n];
        if(m == 0 || n == 0)
            return dp[m][n] = 0;
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return dp[m][n] = 1 + longestCommonSubsequence(s1, s2, m-1, n-1, dp);
        else{
            return dp[m][n] = Math.max(longestCommonSubsequence(s1, s2, m-1, n, dp), longestCommonSubsequence(s1, s2, m, n-1, dp));
        }
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++)
                dp[i][j] = -1;
        }
        return longestCommonSubsequence(text1, text2, m, n, dp);
    }
}