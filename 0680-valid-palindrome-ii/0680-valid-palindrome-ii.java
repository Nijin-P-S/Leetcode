class Solution {
    private boolean palindromeCheck(String s, int left, int right, int count){
        if(count > 1)
            return false;
        if(left >= right)
            return true;
        
        if(s.charAt(left) == s.charAt(right)){
            return palindromeCheck(s, left+1, right-1, count);
        }
        else{
            return palindromeCheck(s, left+1, right, count+1) || palindromeCheck(s, left, right-1, count+1);
        }
    }
    
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        return palindromeCheck(s, left, right, 0);
    }
}