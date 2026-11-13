class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        int idx=0;

        int zeroes=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                idx=i;
                zeroes++;
            }
        }

        if(zeroes>1){
            return ans;
        }

        int product=1;

        if(zeroes==1){
            for(int i=0;i<nums.length;i++){
                if(i==idx){
                    continue;
                }
                product*=nums[i];
            }
            ans[idx]=product;
            return ans;
        }

        for(int i=0;i<nums.length;i++){
            product*=nums[i];
        }

        for(int i=0;i<nums.length;i++){
            ans[i] = product/nums[i];
        }

        return ans;
    }
}  
