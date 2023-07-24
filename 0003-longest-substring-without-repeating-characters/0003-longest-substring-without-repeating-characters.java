class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mapping = new HashMap<>();
        
        int left = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            if(mapping.get(s.charAt(i)) == null || mapping.get(s.charAt(i)) < left)
                mapping.put(s.charAt(i), i);
            else{
                left = mapping.get(s.charAt(i))+1;
                mapping.put(s.charAt(i), i);
            }
            ans = Math.max(ans, i-left+1);
        }
        return ans;
    }
}