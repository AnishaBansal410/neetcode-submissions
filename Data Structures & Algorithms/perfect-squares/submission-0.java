class Solution {
    public int numSquares(int n) {

        int x = (int)Math.sqrt(n);
        int[] nums = new int[x];

        for(int i=0;i<x;i++){
            nums[i]=i+1;
        }

        int[][] dp = new int[nums.length+1][n+1];
        for (int i = 0; i <= x; i++) {
            Arrays.fill(dp[i], n + 1);
            dp[i][0] = 0;
        }
        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<n+1;j++){
                if(nums[i-1]*nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i][j-nums[i-1]*nums[i-1]]+1,dp[i-1][j]);
                }
            }
        }

        return dp[nums.length][n];
    }
}