class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int curH = i;
                int curN = 0;
                while(curH < haystack.length() && curN < needle.length()){
                    if(haystack.charAt(curH) != needle.charAt(curN))
                        break;
                    curH++;
                    curN++;
                }
                if(curN == needle.length())
                    return i;
            }
        }
        return -1;
    }
}