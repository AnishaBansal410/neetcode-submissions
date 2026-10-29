class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }

        int farthest = 0;
        int currFarthest = 0;
        int jumps=0;

        for(int i=0;i<nums.length;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(i==currFarthest){
                jumps++;
                currFarthest=farthest;
            }
            if(currFarthest>=nums.length-1){
                return jumps;
            }
        }

        return jumps;
    }
}
