class Solution {
    class Node{
        int i, j;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Node> map = new HashMap<>();
        for(int i=0; i< mat.length; i++){
            for(int j=0; j< mat[0].length; j++){
                map.put(mat[i][j], new Node(i, j));
            }
        }
        int[] row = new int[mat[0].length];
        for(int i=0; i<mat[0].length; i++)
            row[i] = mat.length;

        int[] col = new int[mat.length];
        for(int i=0; i<mat.length; i++)
            col[i] = mat[0].length;


        for(int i=0; i< arr.length; i++){
            Node cur = map.get(arr[i]);
            int r = cur.i;
            int c = cur.j;

            row[c]--;
            col[r]--;
            if(row[c] == 0 || col[r] == 0)
                return i;
        }
        return -1;
    }
}