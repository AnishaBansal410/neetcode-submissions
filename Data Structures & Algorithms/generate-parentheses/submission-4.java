class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(),n,n,n);
        return ans;
    }

    public void backtrack(StringBuilder sb,int n,int open,int closed){
        if(sb.length()==2*n){
            ans.add(sb.toString());
        }

        if(open>0){
            sb.append("(");
            backtrack(sb,n,open-1,closed);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closed>open){
            sb.append(")");
            backtrack(sb,n,open,closed-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
