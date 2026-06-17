class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        this.st = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!minStack.isEmpty() && minStack.peek()<val){
            minStack.push(minStack.peek());
        }
        else{
            minStack.push(val);
        }
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
