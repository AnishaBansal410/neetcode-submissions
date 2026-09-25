class Solution {
    public int calPoints(String[] operations) {
        int ans=0;
        
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<operations.length;i++){
            String curr = operations[i];
            
            if(curr.equals("+")){
                if(st.size()>=2){
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second);
                    st.push(first);
                    st.push(first+second);
                }
            }
            else if(curr.equals("D")){
                if(!st.isEmpty()){
                    st.push(2*st.peek());
                }
            }
            else if(curr.equals("C")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(Integer.valueOf(curr));
            }
        }

        while(!st.isEmpty()){
            ans+=st.pop();
        }

        return ans;
    }
}