class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int currMaxSum = 0;
        int currMinSum = 0;

        int sum=0;

        int currMax=Integer.MIN_VALUE;
        int currMin=Integer.MAX_VALUE;

        for(int i:nums){
            sum+=i;

            currMaxSum+=i;
            currMinSum+=i;

            currMax = Math.max(currMaxSum,currMax);
            currMin = Math.min(currMinSum,currMin);

            if(currMaxSum<0){
                currMaxSum=0;
            }

            if(currMinSum>0){
                currMinSum=0;
            }
        }

        if(currMax<0){
            return currMax;
        }

        return Math.max(currMax,sum-currMin);
    }
}