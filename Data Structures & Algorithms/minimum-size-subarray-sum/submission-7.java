class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int ans=Integer.MAX_VALUE;
        int i=0,j=0;
        int sum=0;

        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target && i<=j){
                ans=Math.min(ans,j-i+1);
                sum-=nums[i++];
            }
            j++;
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}