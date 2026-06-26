class Solution {
    public int splitArray(int[] nums, int k) {
        int st=Integer.MIN_VALUE;
        int end=0;
        for(int i:nums){
            end+=i;
            st=Math.max(st,i);
        }
        int ans=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(canSplit(nums,k,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }

    public boolean canSplit(int[] nums,int k,int sum){
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            if(curSum+nums[i]>sum){
                k--;
                curSum=0;
            }
            curSum+=nums[i];
        }
        if(curSum!=0){
            k--;
        }
        return k>=0;
    }
}