class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        int maxLength=0;

        for(int i : set){
            if(!set.contains(i-1)){
                int currlength=0;
                while(set.contains(i)){
                    i++;
                    currlength++;
                }
                maxLength=Math.max(currlength,maxLength);
            }
        }

        return maxLength;
    }
}
