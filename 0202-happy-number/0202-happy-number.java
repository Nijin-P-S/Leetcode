class Solution {
    private int findSquare(int n){
        int sq = 0;  
        while(n > 0){
            int rem = n%10;
            sq+= (rem*rem);
            n/=10;
        }
        return sq;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);
        return slow == 1;
    }
}