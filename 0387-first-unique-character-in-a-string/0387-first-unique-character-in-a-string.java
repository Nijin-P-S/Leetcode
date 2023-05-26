class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> unique = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!unique.containsKey(s.charAt(i))){
                unique.put(s.charAt(i), 0);
            }
            unique.put(s.charAt(i), unique.get(s.charAt(i))+1);
        }
        for(int i=0; i<s.length(); i++){
            if(unique.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}