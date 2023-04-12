class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> req = new HashMap<>();
        req.put('b', 1);
        req.put('a', 1);
        req.put('l', 2);
        req.put('o', 2);
        req.put('n', 1);
        
        
        HashMap<Character, Integer> cur = new HashMap<>();
        for(int i=0; i<text.length(); i++){
            if(cur.get(text.charAt(i)) == null)
                cur.put(text.charAt(i), 0);
            cur.put(text.charAt(i), cur.get(text.charAt(i))+1);
        }
        
        int ans = Integer.MAX_VALUE;
        for(char key : req.keySet()){
            if(cur.get(key) == null)
                return 0;
            else{
                ans = Math.min(ans, cur.get(key)/req.get(key));
            }
        }
        return ans;
    }
}