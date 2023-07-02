class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        
        int ind = s.length()-1;
        
        while(ind >= 0 && s.charAt(ind) == ' ')
            ind--;
        
        int end = 0;
        while(end <= ind && s.charAt(end) == ' ')
            end++;
        
        for(int i = ind; i>=end; i--){
            StringBuilder cur = new StringBuilder();
            
            if(s.charAt(i) == ' ')
                continue;
            
            while(i>=0 && s.charAt(i) != ' ')
                cur.append(s.charAt(i--));
            
            if(i<end)
                ans.append(cur.reverse());
            else
                ans.append(cur.reverse()+" ");
        }
        return ans.toString();
    }
}