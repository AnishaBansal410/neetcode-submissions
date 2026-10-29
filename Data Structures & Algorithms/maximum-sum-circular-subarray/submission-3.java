class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int currMax=Integer.MIN_VALUE;
        int currMin=Integer.MAX_VALUE;

        int minSum=0;
        int maxSum=0;
        int sum=0;

        for(int i=0;i<nums.length;i++){

            sum+=nums[i];
            maxSum+=nums[i];
            minSum+=nums[i];
            
            currMax = Math.max(currMax,maxSum);
            currMin = Math.min(currMin,minSum);

            if(maxSum<0){
                maxSum=0;
            }

            if(minSum>0){
                minSum=0;
            }
        }

        if(currMax<0){
            return currMax;
        }

        return Math.max(currMax,sum-currMin);
    }
}