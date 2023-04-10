class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cur = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                cur.append(Character.toLowerCase(s.charAt(i)));
            }
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                cur.append(s.charAt(i));
            }
        }
        
        int left = 0, right = cur.length()-1;
        
        while(left < right){
            if(cur.charAt(left) != cur.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}