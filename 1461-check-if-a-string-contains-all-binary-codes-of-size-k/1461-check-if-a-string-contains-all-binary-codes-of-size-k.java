class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = (int)Math.pow(2, k);
        
        HashSet<String> unique = new HashSet<>();
        
        for(int i=0; i<=s.length()-k; i++){
            unique.add(s.substring(i, i+k));
        }
        
        return unique.size() == count;
    }
}