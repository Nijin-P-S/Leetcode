class MyQueue {
    Stack<Integer> myStack;
    Stack<Integer> helper;
    public MyQueue() {
        myStack = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        myStack.push(x);
    }
    
    public int pop() {
        if(myStack.isEmpty())
            return -1;
        while(!myStack.isEmpty()){
            helper.push(myStack.pop());
        }
        int ans = helper.pop();
        
        while(!helper.isEmpty()){
            myStack.push(helper.pop());
        }
        return ans;
    }
    
    public int peek() {
        if(myStack.isEmpty())
            return -1;
        while(!myStack.isEmpty()){
            helper.push(myStack.pop());
        }
        int ans = helper.peek();
        while(!helper.isEmpty()){
            myStack.push(helper.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return myStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */