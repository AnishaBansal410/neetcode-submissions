class Solution {
    public boolean search(int[] nums, int target) {
        int st=0,end=nums.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(nums[mid]==target){
                return true;
            }
            if (nums[st] == nums[mid] && nums[mid] == nums[end]) {
                st++;
                end--;
                continue;
            }
            if(nums[mid]>=nums[st]){
                if(nums[mid]>target && nums[st]<=target){
                    end=mid-1;
                }
                else{
                    st=mid+1;
                }
            }
            else{
                if(nums[mid]<target && nums[end]>=target){
                    st=mid+1;
                }
                else{
                    end=mid-1;
                }                
            }
        }
        return false;
    }
}