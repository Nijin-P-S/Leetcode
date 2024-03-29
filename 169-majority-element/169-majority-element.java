class Solution {
    
    //Moores Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        
        for(int val : nums){
            if(count == 0){
                ele = val;
            }
            if(ele == val){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }
}