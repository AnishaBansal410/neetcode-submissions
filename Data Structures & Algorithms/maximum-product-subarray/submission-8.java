class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];

        int finalMax = nums[0];

        for(int i=1;i<nums.length;i++){
            int tmp = currMax;
            currMax = Math.max(nums[i],Math.max(currMax*nums[i],currMin*nums[i]));
            currMin = Math.min(nums[i],Math.min(currMin*nums[i],tmp*nums[i]));

            finalMax = Math.max(finalMax,currMax);
        }

        return finalMax;
    }
}
