class Solution {
    public int climbStairs(int n, int[] count){
        if(n==0)
           {
               return count[0] = 1;
           }
        if(n<0)
            return 0;
        if(count[n] != -1)
            return count[n];
        return count[n] = climbStairs(n-1, count) + climbStairs(n-2, count);
        
    }
    public int climbStairs(int n) {
        int[] count = new int[n+1];
        for(int i=0; i<=n; i++)
            count[i] = -1;
        climbStairs(n, count);
        return count[n];
    }
}