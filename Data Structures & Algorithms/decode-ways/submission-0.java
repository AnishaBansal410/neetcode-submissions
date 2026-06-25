class Solution {
    public int numDecodings(String s) {
        HashSet<String> set = new HashSet<>();
        for(int i=1;i<=26;i++){
            set.add(Integer.toString(i));
        }
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        for(int i=0;i<s.length();i++){
            if(dp[i]==0){
                continue;
            }
            for(int j=i+1;j<=s.length() && j<=i+2;j++){
                if(set.contains(s.substring(i,j))){
                    dp[j]+=dp[i];
                }
            }
        }
        return dp[dp.length-1];
    }
}
