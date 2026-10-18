class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int sum=0;
        int length=Integer.MAX_VALUE;

        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>=target){
                length=Math.min(length,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }

        return length==Integer.MAX_VALUE ? 0 : length;
    }
}