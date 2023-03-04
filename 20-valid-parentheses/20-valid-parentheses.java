class Solution {
    public boolean isValid(String s) {
        Stack<Character> valid = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                valid.push(s.charAt(i));
            else{
                if(valid.isEmpty())
                    return false;
                if(s.charAt(i) == ')' && valid.peek()=='(')
                    valid.pop();
                else if(s.charAt(i) == '}' && valid.peek()=='{')
                    valid.pop();
                else if(s.charAt(i) == ']' && valid.peek()=='[')
                    valid.pop(); 
                else
                    return false;
            }
        }
        return valid.isEmpty();
    }
}