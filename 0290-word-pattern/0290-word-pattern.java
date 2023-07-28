class Solution {
        public boolean wordPattern(String pattern, String s) {
        String[] spl = s.split(" ");
        if(pattern.length() != spl.length){
            return false;
        } 
        HashMap<Character, String> pattToS = new HashMap<>();
        HashMap<String, Character> sToPatt = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            if(pattToS.get(pattern.charAt(i)) == null && sToPatt.get(spl[i])==null){
                pattToS.put(pattern.charAt(i), spl[i]);
                sToPatt.put(spl[i], pattern.charAt(i));
            }
            else if(pattToS.get(pattern.charAt(i)) == null && sToPatt.get(spl[i])!=null){
                return false;
            }
            else if(pattToS.get(pattern.charAt(i)) != null && sToPatt.get(spl[i])==null){
                return false;
            }
             else if(!pattToS.get(pattern.charAt(i)).equals(spl[i]) || sToPatt.get(spl[i])!=pattern.charAt(i)){
                return false;
            }
        }
        return true;
    }
}