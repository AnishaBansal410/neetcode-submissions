class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if (Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 != 0) return 0;
        sum=(target+sum)/2;
        int[][] dp = new int[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
