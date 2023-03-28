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
        if(n<=1)
            return n;
        int prev = 1;
        int curr = 1;
        
        for(int i=2; i<=n; i++){
            int temp = prev;
            prev = curr;
            curr = temp+curr;
        }
        return curr;
    }
}