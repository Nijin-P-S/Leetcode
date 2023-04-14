class Solution {
    private void generate(int n, int open, List<String> ans, int close, String cur){
        if(cur.length() == 2*n){
             ans.add(cur);
             return;
         }   
        
        if(open < n)
            generate(n, open+1, ans, close, cur+'(');
        
        if(close < open)
            generate(n, open,ans, close+1, cur+')');
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, 0, ans, 0, "");
        return ans;
    }
}