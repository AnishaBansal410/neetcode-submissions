class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String curr = tokens[i];

            if(curr.equals("+")){
                if(st.size()>=2){
                    st.push(st.pop()+st.pop());
                }
            }
            else if(curr.equals("-")){
                if(st.size()>=2){
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second-first);
                }
            }
            else if(curr.equals("*")){
                if(st.size()>=2){
                    st.push(st.pop()*st.pop());
                }
            }
            else if(curr.equals("/")){
                if(st.size()>=2){
                    int first = st.pop();
                    int second = st.pop();
                    if(first==0 || second==0){
                        st.push(0);
                        continue;
                    }
                    st.push(second/first);
                }
            }
            else{
                st.push(Integer.valueOf(curr));
            }
        }

        return st.pop();
    }
}
