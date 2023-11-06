class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = (int)Math.pow(2, k);
        
        HashSet<String> unique = new HashSet<>();
        
        for(int i=0; i<=s.length()-k; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<i+k; j++){
                sb.append(s.charAt(j));
            }
            unique.add(sb.toString());
        }
        
        return unique.size() == count;
    }
}