class Node{
    int i, j;
    Node(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public boolean canExist(char[][] board, String word, int i, int j, int ind, int[][] vis){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j] == 1)
            return false;
        if(board[i][j] != word.charAt(ind))
            return false;
        if(ind == word.length()-1){
            return board[i][j] == word.charAt(ind);
        }
        vis[i][j] = 1;
        boolean left = canExist(board, word, i, j-1, ind+1, vis);
        boolean right = canExist(board, word, i, j+1, ind+1, vis);
        boolean top = canExist(board, word, i-1, j, ind+1, vis);
        boolean down = canExist(board, word, i+1, j, ind+1, vis);
        vis[i][j] = 0;
        return left || right || top || down;

    }
    
    public boolean exist(char[][] board, String word) {
        Queue<Node> possible = new LinkedList<>();
        //First find the indices having the first char of word
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    possible.add(new Node(i, j));
                }
            }
        }

        while(!possible.isEmpty()){
            Node cur = possible.poll();
            int[][] vis = new int[board.length][board[0].length];
            if(canExist(board, word, cur.i, cur.j, 0, vis) == true){
                return true;
            }
        }
        return false;
    }
}