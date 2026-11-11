class MinStack {
        Deque<Integer> main = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        main.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
        
    }
    
    public void pop() {
        main.pop();
        minStack.pop();
        
    }
    
    public int top() {
        return main.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
