class Solution {
    private boolean checkPal(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    private void dfs(String s, List<List<String>> ans, List<String> cur, int i){
        if(i >= s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for(int j=i; j<s.length(); j++){
            if(checkPal(s, i, j)){
                cur.add(s.substring(i, j+1));
                dfs(s, ans, cur, j+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(s, ans, cur, 0);
        return ans;
    }
}