class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        
        int right = s.length()-1;
        int left = 0;
        while(right>=0 && s.charAt(right)==' '){
            right--;
        }
        while(left<s.length() && s.charAt(left) == ' '){
            left++;
        }
        
        for(int i=right; i>=left; i--){
            if(s.charAt(i) == ' '){
                continue;
            }
            StringBuilder cur = new StringBuilder();
            
            while(i>=0 && s.charAt(i) != ' '){
                cur.append(s.charAt(i));
                i--;
            }
            res.append(cur.reverse().toString());
            if(i>left){
              res.append(" "); 
            }
        }
        return res.toString();
    }
}