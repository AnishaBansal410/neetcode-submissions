class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isPalindrome(s.substring(i,j))){
                    dp[i][j-1]=true;
                }
            }
        }

        partition(s,0,new ArrayList<>(),ans,dp);

        return ans;
    }

    public void partition(String s,int start,List<String> tmp,List<List<String>> ans,boolean[][] dp){
        if(start==s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        StringBuilder temp = new StringBuilder();
        for(int i=start;i<s.length();i++){
            temp.append(s.charAt(i));
            if(dp[start][i]){
                tmp.add(temp.toString());
                partition(s,i+1,tmp,ans,dp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
