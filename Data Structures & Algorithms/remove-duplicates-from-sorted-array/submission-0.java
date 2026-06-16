class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int k=0;
        int ans=0;
        while(i<nums.length){
            nums[k++]=nums[i];
            int j=i+1;
            while(j<nums.length && nums[j]==nums[i]){
                j++;
            }
            i=j;
            ans++;
        }
        return ans;
    }
}