class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }

        int jumps=0;
        int currEnd = nums[0];
        int i=0;
        int farthest = 0;

        while(i<nums.length){
            farthest = Math.max(farthest,nums[i]+i);
            if(i==currEnd){
                currEnd=farthest;
                jumps++;
            }
            if(currEnd>=nums.length-1){
                jumps++;
                return jumps;
            }
            i++;
        }

        return jumps;
    }
}
