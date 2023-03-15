class Node{
    int val;
    int min;
    
    Node(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class MinStack {

    Stack<Node> minStack;
    
    public MinStack() {
        minStack =  new Stack<Node>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()){
            Node cur = new Node(val, val);
            minStack.push(cur);
        }
        else{
            Node cur = new Node(val, Math.min(minStack.peek().min, val));
            minStack.push(cur);
        }
    }
    
    public void pop() {
        if(minStack.isEmpty()){
            return;
        }
        minStack.pop();
    }
    
    public int top() {
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek().val;
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */