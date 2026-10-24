class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int finalAns = nums[0];

        for(int i=1;i<nums.length;i++){
            int tmp = min;

            min = Math.min(nums[i],Math.min(nums[i]*max,nums[i]*min));

            max = Math.max(nums[i],Math.max(nums[i]*tmp,nums[i]*max));

            finalAns = Math.max(max,finalAns);
        }

        return finalAns;
    }
}
