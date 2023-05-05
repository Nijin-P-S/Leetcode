class Solution {
    public boolean checkPalindrome(String s, int i, int j){
        int left = i, right = j;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(checkPalindrome(s, i, j)){
                    count++;
                }
            }
        }
        return count;
    }
}