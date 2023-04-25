class Solution {
    public int characterReplacement(String s, int k) {
        if(s==null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int res = 0;
        int l = 0, r = 0;
        int maxFreq = 0;
        while(r < s.length()){
            if(freq.get(s.charAt(r)) == null){
                freq.put(s.charAt(r), 0);
            }
            freq.put(s.charAt(r), freq.get(s.charAt(r))+1);
            
            for(Character c : freq.keySet()){
                maxFreq = Math.max(maxFreq, freq.get(c));
            }
            int len = (r-l+1) - maxFreq;
            if(len <= k){
                res = Math.max(res, (r-l+1));
                r++;
            }
            else{
                int val = freq.get(s.charAt(l));
                if(val <= 1)
                    freq.put(s.charAt(l), 0);
                else
                    freq.put(s.charAt(l), val-1);
                freq.put(s.charAt(r) , freq.get(s.charAt(r))-1);
                l++;
            }
        }
        return res;
    }
}