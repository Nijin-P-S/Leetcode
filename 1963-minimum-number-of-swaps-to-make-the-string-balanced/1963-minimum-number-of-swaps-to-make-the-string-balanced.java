class Solution {
    public int minSwaps(String s) {
        int max = 0;
        
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ']')
                count++;
            else
                count--;
            max = Math.max(count, max);
        }
        return (max+1)/2;
    }
}