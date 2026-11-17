class Solution {
    public int majorityElement(int[] nums) {
        int candidate=nums[0];

        int ct=0;

        for(int i=0;i<nums.length;i++){
            if(candidate==nums[i]){
                ct++;
            }
            else{
                ct--;
                if(ct<=0){
                    candidate=nums[i];
                    ct++;
                }
            }
        }

        return candidate;
    }
}