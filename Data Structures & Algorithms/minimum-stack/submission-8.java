class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!minSt.isEmpty() && minSt.peek()<val){
            minSt.push(minSt.peek());
        }
        else{
            minSt.push(val);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
            minSt.pop();
        }
    }
    
    public int top() {
        return !st.isEmpty() ? st.peek() : -1;
    }
    
    public int getMin() {
        return !minSt.isEmpty() ? minSt.peek() : -1;
    }
}
