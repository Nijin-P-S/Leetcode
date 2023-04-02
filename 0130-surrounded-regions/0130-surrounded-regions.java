class Solution {
    public void dfs(char[][] board, char[][] vis, int i, int j){
        if(i<0 || i>= board.length || j<0 || j>= board[0].length || vis[i][j] == 'K')
            return;
        if(board[i][j] != 'O')
            return;
        
        if(board[i][j] == 'O'){
            vis[i][j] = 'K';
            dfs(board, vis, i+1, j);
            dfs(board, vis, i-1, j);
            dfs(board, vis, i, j+1);
            dfs(board, vis, i, j-1);
        }
    }
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        char[][] vis = new char[row][col];
        
        for(int i=0; i<row; i++){
            if(board[i][0] == 'O')
                dfs(board, vis, i, 0);
        }
        for(int i=0; i<row; i++){
            if(board[i][col-1] == 'O')
                dfs(board, vis, i, col-1);
        }
        for(int i=0; i<col; i++){
            if(board[0][i] == 'O')
                dfs(board, vis, 0, i);
        }
        for(int i=0; i<col; i++){
            if(board[row-1][i] == 'O')
                dfs(board, vis, row-1, i);
        }
        
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O' && vis[i][j] != 'K')
                    board[i][j] = 'X';
            }
        }
    }
}