class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i=0; i<=n; i++){
            int count = 0;
            int num = i;
            while(num>0){
                if((num & (num-1)) == 0){
                    count = 1;
                    break;
                }
                count+=(num & 1);
                num = num>>1;
                if(num < i)
                {
                    count+=ans[num];
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}