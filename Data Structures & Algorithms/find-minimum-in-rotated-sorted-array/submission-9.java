class Solution {
    public int findMin(int[] nums) {
        int st=0,end=nums.length-1;

        int ans=0;

        while(st<end){
            int mid = st+(end-st)/2;

            if(nums[mid]>nums[end]){
                st=mid+1;
            }
            else{
                end=mid;
            }
        }

        return nums[st];
    }
}
