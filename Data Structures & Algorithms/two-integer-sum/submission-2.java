class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        int diff;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                if(i<map.get(target-nums[i]))
                {   ans[0]=i;
                    ans[1]=map.get(target-nums[i]);
                }
                else{
                    ans[0]=map.get(target-nums[i]);
                    ans[1]=i;
                }
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
