class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int ans=0;
        for(Integer i : set){
            if(set.contains(i-1)){
                continue;
            }
            int j=i;
            int count=0;
            while(set.contains(j)){
                j++;
                count++;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
