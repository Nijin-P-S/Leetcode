class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int maxLen = 0;
        
        for(int i=0; i<s.length(); i++){
            int len = 0;
            
            int left = i-1;
            int right = i+1;
            
            while(left >=0 && s.charAt(left) == s.charAt(i)){
                left--;
            }
            
            while(right <s.length() && s.charAt(right) == s.charAt(i)){
                right++;
            }
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right - left > maxLen){
                StringBuilder curr = new StringBuilder();
                for(int j=left+1; j<right; j++){
                    curr.append(s.charAt(j));
                }
                ans = curr.toString();
                maxLen = right-left;
            }
            
        }
        return ans;
    }
}