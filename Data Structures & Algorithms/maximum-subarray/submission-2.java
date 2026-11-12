class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i:nums){
            currSum+=i;
            sum=Math.max(sum,currSum);
            if(currSum<0){
                currSum=0;
            }
        }

        return sum;
    }
}
