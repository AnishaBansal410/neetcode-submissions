class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,0,0,new StringBuilder(),ans);
        return ans;
    }

    public void generate(int n,int open,int close,StringBuilder curr,List<String> ans){
        if(curr.length()==2*n){
            ans.add(curr.toString());
            return;
        }
        if(open<n){
            curr.append('(');
            generate(n,open+1,close,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            curr.append(')');
            generate(n,open,close+1,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }

}
