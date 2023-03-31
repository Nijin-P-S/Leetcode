class Node{
        int row =0;
        int col = 0;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
}
class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<Node> rot = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    rot.add(new Node(i, j));
                }
            }
        }
        rot.add(null);
        int count = 0;
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while(!rot.isEmpty()){
            Node cur = rot.poll();
            
            if(cur == null){
                if(rot.isEmpty())
                    break;
                else{
                    count++;
                    rot.add(null);
                    continue;
                }
            }
            int row = cur.row;
            int col = cur.col;
            
            for(int i=0; i<4; i++){
                int adjRow = row+delRow[i];
                int adjCol = col+delCol[i];
                
                if(adjRow >=0 && adjRow < grid.length && adjCol >=0 && adjCol < grid[0].length && grid[adjRow][adjCol] == 1){
                    grid[adjRow][adjCol] = 0;
                    rot.add(new Node(adjRow, adjCol));
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }
}