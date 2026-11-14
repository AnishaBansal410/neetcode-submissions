class Solution {
    public int rob(int[] nums) {
        
        // int n = nums.length;

        if(nums.length==1){
            return nums[0];
        }

        // if(nums.length==2){
        //     return Math.max(nums[0],nums[1]);
        // }

        // int[] dp1 = new int[n-1];
        // int[] dp2 = new int[n];

        // dp1[0] = nums[0];
        // dp1[1] = Math.max(nums[0],nums[1]);

        // dp2[1] = nums[1];
        // dp2[2] = Math.max(nums[1],nums[2]);

        // for(int i=2;i<n-1;i++){
        //     dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        // }

        // for(int i=3;i<n;i++){
        //     dp2[i]=Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        // }

        // return Math.max(dp1[n-2],dp2[n-1]);

        int[] tmp = new int[nums.length-1];

        int ans=0;

        for(int i=0;i<nums.length-1;i++){
            tmp[i]=nums[i];
        }

        ans=Math.max(ans,robb(tmp));

        for(int i=1;i<nums.length;i++){
            tmp[i-1]=nums[i];
        }

        ans=Math.max(ans,robb(tmp));

        return ans;
    }

    public int robb(int[] nums){
        int[] dp = new int[nums.length+1];

        if(nums.length==1){
            return nums[0];
        }

        dp[1]=nums[0];

        for(int i=2;i<=nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }

        return dp[nums.length];
    }
}
