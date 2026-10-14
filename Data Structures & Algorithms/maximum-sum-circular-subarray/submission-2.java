class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax=0;
        int currMin=0;
        int sum=0;
        int finalMax=Integer.MIN_VALUE;
        int finalMin=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            currMax+=nums[i];
            finalMax = Math.max(finalMax,currMax);

            if(currMax<0){
                currMax=0;
            }

            currMin+=nums[i];
            finalMin = Math.min(finalMin,currMin);
            if(currMin>0){
                currMin=0;
            }
        }
        if(finalMax<0){
            return finalMax;
        }

        return Math.max(finalMax,sum-finalMin);
    }
}