class Solution {
    // int ans = 0;
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        Arrays.sort(nums);
        combinations(nums,target,dp);
        return dp[target];
    }

    public int combinations(int[] nums,int target,int[] dp){
        if(dp[target]!=0){
            return dp[target];
        }
        if(target<0){
            return 0;
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                break;
            }
            ans+=combinations(nums,target-nums[i],dp);
        }
        dp[target]=ans;
        return ans;
    }
}