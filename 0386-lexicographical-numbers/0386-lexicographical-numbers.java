class Solution {
    private void add(int n, int cur, List<Integer> ans, HashSet<Integer> vis){ 
        if(cur > n)
            return;
        if(vis.contains(cur))
            return;
        vis.add(cur);
        ans.add(cur);

        int temp = cur*10;
        while(temp <= n){
            add(n, temp, ans, vis);
            temp*=10;
        }

        for(int i=1; i<10; i++){
            if(cur+i > n || vis.contains(cur+i))
                continue;
            ans.add(cur+i);
            vis.add(cur+i);

            add(n, (cur+i)*10, ans, vis);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        for(int i=1; i<=n; i++){
            if(vis.contains(i))
                continue;
            ans.add(i);
            add(n, i*10, ans, vis);
        }
        return ans;
    }
}