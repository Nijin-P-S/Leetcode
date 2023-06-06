class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        int rowSeenCount = 0, colSeenCount = 0;
        boolean[] rowSeen = new boolean[n];
        boolean[] colSeen = new boolean[n];
        
        long sum = 0l;
        
        for(int i=queries.length-1; i>=0; i--){
            int type= queries[i][0], index = queries[i][1], val = queries[i][2];
            if(type == 0 && !rowSeen[index]){
                rowSeenCount++;
                rowSeen[index] = true;
                sum+= (n-colSeenCount)*val;
            }
            if(type == 1 && !colSeen[index]){
                colSeenCount++;
                colSeen[index] = true;
                sum+= (n-rowSeenCount)*val;
            }
        }
        return sum;
    }
}


