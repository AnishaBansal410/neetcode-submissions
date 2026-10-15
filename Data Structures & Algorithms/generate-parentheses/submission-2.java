class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,0,0,new StringBuilder(),n);
        return ans;
    }

    public void backtrack(List<String> ans,int open,int close,StringBuilder s,int n){
        if(s.length()==2*n){
            ans.add(s.toString());
            return;
        }
        if(open<n){
            s.append("(");
            backtrack(ans,open+1,close,s,n);
            s.deleteCharAt(s.length()-1);
        }
        if(close<open){
            s.append(")");
            backtrack(ans,open,close+1,s,n);
            s.deleteCharAt(s.length()-1);
        }
    }
}
