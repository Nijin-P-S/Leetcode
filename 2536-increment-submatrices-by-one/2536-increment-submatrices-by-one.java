class Solution {
    public void change(int[][] mat, int r1, int c1, int r2, int c2){
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                mat[i][j]++;
            }
        }
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int matrix[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                matrix[i][j] = 0;
        }
        for(int i=0; i<queries.length; i++){
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            change(matrix, r1,c1,r2,c2);
        }
        return matrix;
    }
}