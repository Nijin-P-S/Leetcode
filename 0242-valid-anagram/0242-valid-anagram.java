class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character, Integer> freqS = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            if(freqS.get(s.charAt(i)) == null)
                freqS.put(s.charAt(i), 0);
            freqS.put(s.charAt(i), freqS.get(s.charAt(i))+1);
        }
        
        for(int i=0; i<t.length(); i++){
            if(freqS.get(t.charAt(i)) == null || freqS.get(t.charAt(i)) == 0)
                return false;
            freqS.put(t.charAt(i), freqS.get(t.charAt(i))-1);
        }
        return true;
    }
}