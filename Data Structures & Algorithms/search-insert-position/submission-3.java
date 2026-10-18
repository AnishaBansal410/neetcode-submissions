class Solution {
    public int searchInsert(int[] nums, int target) {
        int st=0,end=nums.length-1;
        int ans=-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                ans=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans+1;
    }
}