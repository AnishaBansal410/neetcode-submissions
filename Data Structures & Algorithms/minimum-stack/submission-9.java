class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || minSt.peek()>val){
            minSt.push(val);
            return;
        }

        minSt.push(minSt.peek());
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        return st.peek();      
    }
    
    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }
        return minSt.peek();
    }
}
