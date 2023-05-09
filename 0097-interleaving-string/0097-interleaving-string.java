class Solution {
    private boolean isPossible(String s1, String s2, String s3, int p1, int p2, int p3, int[][] dp){
        if(p3 == s3.length() && p1 == s1.length() && p2 == s2.length())
            return true;
        
        if(dp[p1][p2] != -1)
            return dp[p1][p2] == 1;
        boolean s1Poss = false, s2Poss = false;
        if(p1 < s1.length() && s1.charAt(p1)== s3.charAt(p3))
            s1Poss = isPossible(s1, s2, s3, p1+1, p2, p3+1, dp);
        if(p2 < s2.length() && s2.charAt(p2)== s3.charAt(p3))
            s2Poss = isPossible(s1, s2, s3, p1, p2+1, p3+1, dp);
        
        dp[p1][p2] = (s1Poss || s2Poss) ? 1 : 0;
        return s1Poss || s2Poss;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
            return false;
        
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i<= s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        
        
        return isPossible(s1, s2, s3, 0, 0, 0, dp);
        
    }
}