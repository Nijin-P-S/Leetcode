class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        
        int carry = 0;
        for(int i=num.length-1; i>=0; i--){
            int sum = num[i] + k%10 + carry;
            carry = sum/10;
            ans.add(sum%10);
            k/=10;
        }
        if(carry != 0 || k > 0){
            while(carry !=0 || k > 0){
                int sum = carry + k%10;
                carry = sum/10;
                ans.add(sum%10);
                k/=10;
            }
        }
            
        Collections.reverse(ans);
        return ans;
    }
}