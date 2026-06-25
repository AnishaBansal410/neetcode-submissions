class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int INF = amount + 1;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1;i<amount+1;i++){
            dp[0][i]=INF;
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }
        if(dp[coins.length][amount]==INF){
            return -1;
        }
        return dp[coins.length][amount];
    }
}
