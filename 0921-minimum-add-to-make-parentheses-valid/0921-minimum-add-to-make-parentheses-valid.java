class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> para = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(para.isEmpty()){
                para.push(s.charAt(i));
            }
            else if(para.peek() == '(' && s.charAt(i) == ')'){
                para.pop();
            }
            else{
                para.push(s.charAt(i));
            }
        }
        return para.size();
    }
}