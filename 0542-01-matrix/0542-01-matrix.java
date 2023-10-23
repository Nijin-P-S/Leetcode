class Node{
    int i, j, time;
    public Node(int i, int j, int time){
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        boolean[][] vis = new boolean[row][col];
        
        Queue<Node> queue = new LinkedList<>();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j] == 0){
                    queue.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int i = cur.i;
            int j = cur.j;
            int time = cur.time;
            
            //Check left
            if(j-1 >= 0 && !vis[i][j-1] && mat[i][j-1] == 1){
                queue.add(new Node(i, j-1, time+1));
                vis[i][j-1] = true;
                mat[i][j-1] = time+1; 
            }
            //Check right
            if(j+1 < col && !vis[i][j+1] && mat[i][j+1] == 1){
                queue.add(new Node(i, j+1, time+1));
                vis[i][j+1] = true;
                mat[i][j+1] = time+1; 
            }
            //Check top
            if(i-1 >= 0 && !vis[i-1][j] && mat[i-1][j] == 1){
                queue.add(new Node(i-1, j, time+1));
                vis[i-1][j] = true;
                mat[i-1][j] = time+1; 
            }
            //Check down
            if(i+1 < row && !vis[i+1][j] && mat[i+1][j] == 1){
                queue.add(new Node(i+1, j, time+1));
                vis[i+1][j] = true;
                mat[i+1][j] = time+1; 
            }
        }
        return mat;
    }
}