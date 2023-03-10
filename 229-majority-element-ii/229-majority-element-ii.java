class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        
        for(int val : nums){
            if(val == num1)count1++;
            else if(val == num2)count2++;
            
            else if(count1 == 0){
                count1 = 1;
                num1 = val;}
            else if(count2 == 0){
                count2 = 1;
                num2 = val;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        
        int req= nums.length/3+1;
        count1 = 0;
        count2 = 0;
        List<Integer> ans = new ArrayList<>();
        
        for(int val : nums){
            if(val == num1)count1++;
            else if(val == num2)count2++;
        }
        if(count1>=req)
            ans.add(num1);
        if(count2 >= req)
            ans.add(num2);
        
        return ans;
    }
}