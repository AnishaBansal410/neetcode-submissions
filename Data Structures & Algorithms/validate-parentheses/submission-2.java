class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c=='{' || c=='(' || c=='['){
                st.push(c);
                continue;
            }

            if(c==')' && (st.isEmpty() || !st.isEmpty() && st.peek()!='(')){
                return false;
            }
            else if(c==']' && (st.isEmpty() || !st.isEmpty() && st.peek()!='[')){
                return false;
            }
            else if(c=='}' && (st.isEmpty() || !st.isEmpty() && st.peek()!='{')){
                return false;
            }
            else{
                st.pop();
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
