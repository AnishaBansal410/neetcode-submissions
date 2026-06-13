class Solution {
    public int maxSubArray(int[] nums) {
        int cursum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            cursum+=nums[i];
            maxSum=Math.max(cursum,maxSum);
            if(cursum<0){
                cursum=0;
            }
        }
        return maxSum;
    }
}
