class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for(String st:wordDict){
            set.add(st);
        }

        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;

        for(int i=0;i<s.length();i++){
            if(!dp[i]){
                continue;
            }

            for(int j=i;j<=s.length();j++){
                if(set.contains(s.substring(i,j))){
                    dp[j]=true;
                }
            }
        }

        return dp[s.length()];
    }
}
