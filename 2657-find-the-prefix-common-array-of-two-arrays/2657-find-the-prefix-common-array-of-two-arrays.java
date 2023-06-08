class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> tillNow = new HashSet<>();
        int[] ans = new int[A.length];
        for(int i=0; i<A.length; i++){
            int count = 0;
            tillNow.add(A[i]);
            for(int j=i; j>=0; j--){
                if(tillNow.contains(B[j]))
                    count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}