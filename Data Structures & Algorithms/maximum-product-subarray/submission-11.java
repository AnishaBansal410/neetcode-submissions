class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;

        int currMax = 1;
        int currMin = 1;

        for(int i=0;i<nums.length;i++){
            int tmp = currMin;

            currMin = Math.min(nums[i],Math.min(currMin*nums[i],currMax*nums[i]));

            currMax = Math.max(nums[i],Math.max(tmp*nums[i],currMax*nums[i]));

            ans=Math.max(ans,currMax);

        }

        return ans;
    }
}
