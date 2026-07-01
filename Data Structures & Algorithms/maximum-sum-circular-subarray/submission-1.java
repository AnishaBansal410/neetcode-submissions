class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax=0;
        int curMin=0;
        int i=0;
        int sum=0;
        int finalMax=Integer.MIN_VALUE;
        int finalMin=Integer.MAX_VALUE;
        while(i<nums.length){
            curMax+=nums[i];
            curMin+=nums[i];
            sum+=nums[i];
            finalMax=Math.max(finalMax,curMax);
            finalMin=Math.min(curMin,finalMin);
            if(curMax<0){
                curMax=0;
            }
            if(curMin>0){
                curMin=0;
            }
            i++;
        }
        if(finalMax<0){
            return finalMax;
        }
        return Math.max(finalMax,sum-finalMin);
    }
}