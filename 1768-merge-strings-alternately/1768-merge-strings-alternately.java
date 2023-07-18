class Solution {
    public String mergeAlternately(String word1, String word2) {
        int ind1 = 0, ind2 = 0;
        
        StringBuilder ans = new StringBuilder();
        
        int n = Math.min(word1.length(), word2.length());
        
        for(int i=0; i<2*n; i++){
            if(i%2 == 0){
                ans.append(word1.charAt(ind1++));
            }    
            else
                ans.append(word2.charAt(ind2++));
        }
        
        if(ind1 < word1.length())
            ans.append(word1.substring(ind1, word1.length()));
        if(ind2 < word2.length())
            ans.append(word2.substring(ind2, word2.length()));
        
        return ans.toString();
    }
}