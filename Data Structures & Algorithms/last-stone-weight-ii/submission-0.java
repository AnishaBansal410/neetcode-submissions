class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i:stones){
            sum+=i;
        }
        int stonesum=sum;
        sum=sum/2;
        int[][] dp = new int[stones.length+1][sum+1];
        
        for(int i=1;i<stones.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(stones[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(stones[i-1]+dp[i-1][j-stones[i-1]],dp[i-1][j]);
                }
            }
        }

        return stonesum-2*dp[stones.length][sum];
    }
}