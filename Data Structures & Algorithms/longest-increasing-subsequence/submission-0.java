class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(1+dp[j],dp[i]);
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i:dp){
            ans=Math.max(ans,i);
        }
        return ans;
    }
}
