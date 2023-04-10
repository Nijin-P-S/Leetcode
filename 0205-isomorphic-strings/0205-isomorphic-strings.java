class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Character> sTot = new HashMap<>();
        HashMap<Character, Character> tTos = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            if(sTot.get(s.charAt(i)) == null && tTos.get(t.charAt(i)) == null){
                sTot.put(s.charAt(i), t.charAt(i));
                tTos.put(t.charAt(i), s.charAt(i));
            }
            else if(sTot.get(s.charAt(i)) != null && tTos.get(t.charAt(i)) != null && sTot.get(s.charAt(i)) == t.charAt(i) && tTos.get(t.charAt(i)) == s.charAt(i)){
                continue;
            }
            else
                return false;
        }
        return true;
    }
}