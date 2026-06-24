class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        if(cost.length==1){
            return cost[0];
        }
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=cost.length;i++){
            dp[i]=Math.min(cost[i-2]+dp[i-2],cost[i-1]+dp[i-1]);
        }
        return dp[cost.length];
    }
}
