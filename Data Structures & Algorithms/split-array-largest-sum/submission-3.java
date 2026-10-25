class Solution {
    public int splitArray(int[] nums, int k) {

        int sum = 0;
        int st=Integer.MIN_VALUE;

        for(int i:nums){
            sum+=i;
            st=Math.max(st,i);
        }

        int end=sum;
        int ans=0;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(isValid(nums,k,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] nums,int k,int sum){
        
        int i=0;
        int arrays = 0;

        while(i<nums.length){
            int curr=0;
            int j=i;

            while(j<nums.length && curr+nums[j]<=sum){
                curr+=nums[j];
                j++;
            }
            arrays++;
            i=j;
        }

        return arrays<=k;
    }
}