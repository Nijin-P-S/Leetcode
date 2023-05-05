class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            int left = i, right = i;
            while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                left = i;
                right = i+1;
                while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }
            }
        }
        return count;
    }
}