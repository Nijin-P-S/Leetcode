class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
            int sum = digits[i] + carry;
            res.add(sum%10);
            carry = sum/10;
        }
        if(carry != 0){
            res.add(carry);
        }

        
        int[] arr = new int[res.size()];
        int ind = res.size()-1;
        for(int i=res.size()-1; i>=0; i--)
            arr[ind-i] = res.get(i);
        return arr;
    }
}