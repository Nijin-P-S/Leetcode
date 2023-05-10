class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anag = new HashMap<>();
        
        for(String s : strs){
            int[] cur = new int[26];
            for(int i=0; i<s.length(); i++){
                cur[s.charAt(i)-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i=0; i<26; i++){
                key.append(cur[i]+",");
            }
            if(!anag.containsKey(key.toString())){
                anag.put(key.toString(), new ArrayList<>());
            }
            List<String> list = anag.get(key.toString());
            list.add(s);
            anag.put(key.toString(), list);
        }
        
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(anag.values());
        
        return ans;
    }
}