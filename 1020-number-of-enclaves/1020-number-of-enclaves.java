class Solution {
    public void dfs(int i, int j, int row, int col , int[][] vis, int[][] grid){
        if(i<0 || i>=row || j<0 || j>=col || vis[i][j] == 1)
            return;
        vis[i][j] = 1;
        
        if(i+1 < row && grid[i+1][j] == 1){
            dfs(i+1, j, row, col, vis, grid);
        }
        if(i-1 >0 && grid[i-1][j] == 1){
            dfs(i-1, j, row, col, vis, grid);
        }
        if(j+1 < col && grid[i][j+1] == 1){
            dfs(i, j+1, row, col, vis, grid);
        }
        if(j-1 >= 0 && grid[i][j-1] == 1){
            dfs(i, j-1, row, col, vis, grid);
        }
    }
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        
        for(int i=0; i<row; i++){
            if(grid[i][0] == 1)
                dfs(i, 0, row, col, vis, grid);
        }
        for(int i=0; i<row; i++){
            if(grid[i][col-1] == 1)
                dfs(i, col-1, row, col, vis, grid);
        }
        for(int i=0; i<col; i++){
            if(grid[0][i] == 1)
                dfs(0, i, row, col, vis, grid);
        }
        for(int i=0; i<col; i++){
            if(grid[row-1][i] == 1)
                dfs(row-1, i, row, col, vis, grid);
        }
        
        int count = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)
            {
                if(grid[i][j] == 1 && vis[i][j] != 1)
                    count++;
            }
        }
        return count;
    }
}