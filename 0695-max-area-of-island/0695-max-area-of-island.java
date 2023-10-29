class Node{
    int i, j;
    Node(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    private int bfs(int[][] grid, boolean[][] vis, int i, int j, int row, int col){
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        queue.add(new Node(i, j));
        vis[i][j] = true;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            count++;
            i = cur.i;
            j = cur.j;
            //Check left
            if(j-1 >= 0 && !vis[i][j-1] && grid[i][j-1] == 1){
                vis[i][j-1] = true;
                queue.add(new Node(i, j-1));
            }
            //Check right
            if(j+1 < col && !vis[i][j+1] && grid[i][j+1] == 1){
                vis[i][j+1] = true;
                queue.add(new Node(i, j+1));
            }
            //Check top
            if(i-1 >= 0 && !vis[i-1][j] && grid[i-1][j] == 1){
                vis[i-1][j] = true;
                queue.add(new Node(i-1, j));
            }
            //Check dowm
            if(i+1 < row && !vis[i+1][j] && grid[i+1][j] == 1){
                vis[i+1][j] = true;
                queue.add(new Node(i+1, j));
            }
        }
        return count;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        int row = grid.length, col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    count = Math.max(count, bfs(grid, vis, i, j, row, col));
                }
            }
        }
        return count;
    }
}