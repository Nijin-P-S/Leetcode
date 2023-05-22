class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder ans = new StringBuilder();
        int left= 0, right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) == s.charAt(right))
                ans.append(s.charAt(left));
            else{
                int compare = Character.compare(s.charAt(left), s.charAt(right));
                if(compare>0)
                    ans.append(s.charAt(right));
                else
                    ans.append(s.charAt(left));
            }
            left++;
            right--;
        }
        int ind = 0;
        if(s.length()%2 != 0)
            ind+=1;
        int size = ans.length()-1;
        while(size-ind >= 0){
            ans.append(ans.charAt(size-ind));
            ind++;
        }
        return ans.toString();
    }
}