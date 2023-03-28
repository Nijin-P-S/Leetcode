class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        int ind = 0;
        String alpha = "abcdefghijklmnopqrstuvwxyz";  
        for(int i=0; i<key.length(); i++){
            if(key.charAt(i) == ' '){
                continue;
            }
            else if(map.get(key.charAt(i)) == null){
                map.put(key.charAt(i), alpha.charAt(ind));
                ind++;
            }
        } 
        StringBuilder ans = new StringBuilder();
        for(int i =0; i<message.length(); i++){
            if(message.charAt(i) == ' '){
                ans.append(' ');
                continue;
            }
            ans.append(map.get(message.charAt(i)));
        }
        
        return ans.toString();
    }
}