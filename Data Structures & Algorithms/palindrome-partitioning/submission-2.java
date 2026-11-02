class Solution {

    List<List<String>> ans = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s,i,j)){
                    dp[i][j]=true;
                }
            }
        }

        backtrack(s,0,new ArrayList<>());
        return ans;
    }

    public void backtrack(String s,int st,List<String> tmp){
        if(st==s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=st;i<s.length();i++){
            sb.append(s.charAt(i));
            if(dp[st][i]){
                tmp.add(sb.toString());
                backtrack(s,i+1,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int st,int end){
        while(st<=end){
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}
