class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length==1){
            return List.of(nums[0]);
        }

        int candidate1 = nums[0];
        int candidate2 = nums[1];

        int ct1 = 0;
        int ct2 = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate1){
                ct1++;
            }

            else if(nums[i]==candidate2){
                ct2++;
            }

            else if(ct1==0){
                candidate1 = nums[i];
                ct1++;
            }

            else if(ct2==0){
                candidate2=nums[i];
                ct2++;
            }

            else{
                ct1--;
                ct2--;
            }

        }

        ct1=0;
        ct2=0;

        for(int i:nums){
            if(i==candidate1){
                ct1++;
            }
            else if(i==candidate2){
                ct2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if(ct1>nums.length/3){
            ans.add(candidate1);
        }

        if(ct2>nums.length/3){
            ans.add(candidate2);
        }

        return ans;
    }
}