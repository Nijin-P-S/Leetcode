class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;

        int color[]=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(checkBipartite(i,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBipartite(int i,int[][] graph,int color[]){
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        color[i]=0;

        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int e: graph[node]){
                if(color[e]==-1){
                    color[e]=1-color[node];
                    q.add(e);
                }
                else if(color[e]==color[node]){
                    return false;
                }
            }
            
        }
        return true;

    }
}