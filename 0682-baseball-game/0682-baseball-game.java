class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> ans = new Stack<>();
        
        for(int i=0; i<operations.length; i++){
            if(operations[i].charAt(0) == '+'){
                int first = ans.pop();
                int cur = first + ans.peek();
                ans.push(first);
                ans.push(cur);
            }
            else if(operations[i].charAt(0) == 'D'){
                ans.push(2*ans.peek());
            }
            else if(operations[i].charAt(0) == 'C'){
                ans.pop();
            }
            else{
                ans.push(Integer.parseInt(operations[i]));
            }
        }
        
        int sum = 0;
        while(!ans.isEmpty()){
            sum+= ans.pop();
        }
        return sum;
    }
}