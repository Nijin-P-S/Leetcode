class Solution {
    // public int maxConsecutiveAnswers(String answerKey, int k) {
//         int ans = 0;
        
//         for(int i=0; i<answerKey.length(); i++){
//             int curCount = 0;
//             int countK = 0;
//             for(int j=i; j<answerKey.length(); j++){
//                 if(answerKey.charAt(j) == 'T')
//                     curCount++;
//                 else if(countK >= k)
//                     break;
//                 else{
//                     curCount++;
//                     countK++;
//                 }
//                 ans = Math.max(curCount, ans);
//             }
//         }
        
//         for(int i=0; i<answerKey.length(); i++){
//             int curCount = 0;
//             int countK = 0;
//             for(int j=i; j<answerKey.length(); j++){
//                 if(answerKey.charAt(j) == 'F')
//                     curCount++;
//                 else if(countK >= k)
//                     break;
//                 else{
//                     curCount++;
//                     countK++;
//                 }
//                 ans = Math.max(curCount, ans);
//             }
//         }
//         return ans;
        
        
    // }
    
     public int maxConsecutiveAnswers(String s, int k) {
        int res = 0, maxf = 0, count[] = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            maxf = Math.max(maxf, ++count[s.charAt(i)]);
            if (res - maxf < k)
                res++;
            else
                count[s.charAt(i - res)]--;
        }
        return res;
    }
}