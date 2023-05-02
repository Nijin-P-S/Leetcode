class Solution {
    private int numDecodings(String s, int ind, int n, int[] dp){
        if(ind >= n || s.charAt(ind) == '0')
            return 0;
        if(ind == n-1)
            return 1;
        
        if(dp[ind] != -1)
            return dp[ind];
        int single = numDecodings(s, ind+1, n, dp);
        int combine = 0;
        if(ind+1 <= n-1){
            int combNo = Integer.parseInt(s.charAt(ind) +""+s.charAt(ind+1));
            if(combNo <= 26 && ind+1 < n-1)
                combine = numDecodings(s, ind+2, n, dp);
            else if(combNo <= 26 && ind+1 == n-1)
                combine = 1;
            else if(combNo > 26)
                combine = 0;
        }
        return dp[ind] = single+combine;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for(int i=0; i<s.length();i++){
            dp[i] = -1;
        }
        return numDecodings(s, 0, s.length(), dp);
    }
}