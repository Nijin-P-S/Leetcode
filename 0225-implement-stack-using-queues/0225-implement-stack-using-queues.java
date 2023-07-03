class MyStack {
    Queue<Integer> queue;
    Queue<Integer> helper;

    public MyStack() {
        queue = new LinkedList<>();
        helper = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        
    }
    
    public int pop() {
        if(empty())
            return -1;
        while(queue.size() > 1){
            helper.add(queue.poll());
        }
        int ans = queue.poll();
        
        while(!helper.isEmpty())
            queue.add(helper.poll());
        return ans;
    }
    
    public int top() {
        if(empty())
            return -1;
        while(queue.size() > 1){
            helper.add(queue.poll());
        }
        int ans = queue.poll();
        
        while(!helper.isEmpty())
            queue.add(helper.poll());
        queue.add(ans);
        return ans;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */