class BrowserHistory {
    Stack<String> hist;
    Stack<String> frw;
    
    public BrowserHistory(String homepage) {
        hist = new Stack<>();
        frw = new Stack<>();
        hist.push(homepage);
    }
    
    public void visit(String url) {
        hist.push(url);
        frw.clear();
    }
    
    public String back(int steps) {
        
        while(steps > 0 && hist.size() > 1){
            frw.push(hist.pop());
            steps--;
        }
        return hist.peek();
    }
    
    public String forward(int steps) {
        
        while(steps > 0 && frw.size() > 0){
            hist.push(frw.pop());
            steps--;
        }
        
        return hist.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */