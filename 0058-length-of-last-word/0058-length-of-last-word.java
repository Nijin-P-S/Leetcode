class Solution {
    public int lengthOfLastWord(String s) {
        int ind = s.length()-1;
        while(ind >= 0 && s.charAt(ind) == ' ')
            ind--;
        
        int count = 0;
        
        while(ind >= 0 && s.charAt(ind) != ' ')
        {
            ind--;
            count++;
        }
        return count;
    }
}