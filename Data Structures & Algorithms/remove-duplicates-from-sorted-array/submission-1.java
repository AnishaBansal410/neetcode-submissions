class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        int i=0;
        while(i<nums.length){
            nums[k]=nums[i];
            k++;
            int j=i+1;
            while(j<nums.length && nums[j]==nums[i]){
                j++;
            }
            i=j;
        }
        return k;
    }
}