class Solution {
    private boolean checkBip(int[][] graph,int[] color, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int adj : graph[cur]){
                if(color[adj] == -1){
                    color[adj] = 1 - color[cur];
                    q.add(adj);
                }
                else if(color[adj] == color[cur])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0; i<graph.length; i++)color[i] = -1;
        
        
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1)
                if(checkBip(graph, color, i) == false)
                    return false;
        }
        return true;
    }
}



// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int n=graph.length;

//         int color[]=new int[n];
//         Arrays.fill(color,-1);

//         for(int i=0;i<n;i++){
//             if(color[i]==-1){
//                 if(checkBipartite(i,graph,color)==false){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     public boolean checkBipartite(int i,int[][] graph,int color[]){
//         Queue<Integer>q=new LinkedList<>();
//         q.add(i);
//         color[i]=0;

//         while(!q.isEmpty()){
//             int node=q.poll();
            
//             for(int e: graph[node]){
//                 if(color[e]==-1){
//                     color[e]=1-color[node];
//                     q.add(e);
//                 }
//                 else if(color[e]==color[node]){
//                     return false;
//                 }
//             }
            
//         }
//         return true;

//     }
// }