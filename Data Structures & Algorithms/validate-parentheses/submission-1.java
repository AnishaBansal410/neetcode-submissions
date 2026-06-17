class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(!st.isEmpty() && c==')'){
                if(st.pop()!='('){
                    return false;
                }
            }
            else if(!st.isEmpty() && c==']'){
                if(st.pop()!='['){
                    return false;
                }
            }
            else if(!st.isEmpty() && c=='}'){
                if(st.pop()!='{'){
                    return false;
                }
            }
            else{
                st.push(c);
            }
            i++;
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
