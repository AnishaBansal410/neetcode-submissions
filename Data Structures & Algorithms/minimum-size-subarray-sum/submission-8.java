class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int i=0,j=0;
        int length=Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>=target){
                length = Math.min(length,j-i+1);
                sum-=nums[i++];
            }
            j++;
        }
        if(length==Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
}