class Solution {
    private int reverse(int x){
        int rev = 0;
        
        while(x > 0){
            int rem = x%10;
            rev = (rev*10)+rem;
            x/=10;
        }
        return rev;
    }
    public boolean isPalindrome(int x) {
        int rev = reverse(x);
        return rev == x;
    }
}