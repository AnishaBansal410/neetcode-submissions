class Solution {
    public int findMin(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(mid==0){
                if(nums[mid]>nums[nums.length-1]){
                    i=mid+1;
                }
                else{
                    return nums[0];
                }
            }
            else{
                if(nums[mid]<nums[mid-1]){
                    return nums[mid];
                }
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[nums.length-1]){
                    i=mid+1;
                }
                else{
                    j=mid-1;
                }
            }
        }
        return nums[0];
    }
}
