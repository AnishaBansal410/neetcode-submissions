class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;

        int ans=Integer.MAX_VALUE;
        int sum=0;

        while(j<nums.length){
            sum+=nums[j];

            while(i<=j && sum>=target){
                ans=Math.min(ans,j-i+1);
                sum-=nums[i++];
            }
            j++;
        }

        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}