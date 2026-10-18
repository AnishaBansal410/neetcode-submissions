class Solution {
    public int splitArray(int[] nums, int k) {
        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int x:nums){
            max = Math.max(max,x);
            sum+=x;
        }
        
        int st=max,end=sum;
        int ans = 0;

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
        int numberOfArrays=0;
        while(i<nums.length){
            int currSum=0;
            int j=i;
            while(j<nums.length && currSum+nums[j]<=sum){
                currSum+=nums[j];
                j++;
            }
            numberOfArrays++;
            i=j;
        }
        return numberOfArrays<=k;
    }
}