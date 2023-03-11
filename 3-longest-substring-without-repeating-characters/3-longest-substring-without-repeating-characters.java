class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        HashSet<Character> uni = new HashSet<>();
        
        int maxCount = 1;
        
        int left = 0, right=0;
        while(right < s.length()){
            if(!uni.contains(s.charAt(right))){
                uni.add(s.charAt(right));
            }
            else{
                while(uni.contains(s.charAt(right))){
                    uni.remove(s.charAt(left));
                    left++;
                }
                uni.add(s.charAt(right));
            }
            right++;
            maxCount = Math.max(maxCount, right-left);
        }
        return maxCount;
    }
}