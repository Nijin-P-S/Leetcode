class Node{
    int max, min;
    
    public Node(int max, int min){
        this.max = max;
        this.min = min;
    }
}
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Node> stack = new Stack<>();
        
        int curMin = nums[0];
        
        for(int i=1; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i] > stack.peek().max)
                stack.pop();
            if(!stack.isEmpty() && stack.peek().max > nums[i] && stack.peek().min < nums[i])
                return true;
            
            stack.push(new Node(nums[i], curMin));
            curMin = Math.min(nums[i], curMin);
        }
        return false;
    }
}