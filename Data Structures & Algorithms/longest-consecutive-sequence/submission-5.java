class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        int len=0;

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }

            int curr=0;
            int j=nums[i];
            while(set.contains(j)){
                curr++;
                j++;
            }

            len=Math.max(curr,len);
        }

        return len;
    }
}
