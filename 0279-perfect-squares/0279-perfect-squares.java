class Solution {
    private int numSquares(int n, int[] dp){
        if(n == 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        
        int count = Integer.MAX_VALUE;
        
        for(int i=1; i*i<=n; i++){
            count = Math.min(1+numSquares(n-(i*i), dp), count);
        }
        return dp[n] = count;
    }
    
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        
        return numSquares(n, dp);
    }
}