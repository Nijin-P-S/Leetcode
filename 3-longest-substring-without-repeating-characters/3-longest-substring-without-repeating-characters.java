class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        HashMap<Character, Integer> uni = new HashMap<>();
        
        int maxCount = 1;
        
        int left = 0, right=0;
        while(right < s.length()){
            if(uni.get(s.charAt(right)) == null || uni.get(s.charAt(right)) < left){
                uni.put(s.charAt(right), right);
            }
            else{
                int ind = uni.get(s.charAt(right));
                left = ind+1;
                uni.put(s.charAt(right), right);
            }
            right++;
            maxCount = Math.max(maxCount, right-left);
        }
        return maxCount;
    }
}