class Solution {
    public int splitArray(int[] nums, int k) {

        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int i:nums){
            max=Math.max(i,max);
            sum+=i;
        }

        int st = max;
        int end = sum;
        int ans=-1;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(isValid(nums,mid,k)){
                end=mid-1;
                ans=mid;
            }
            else{
                st=mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] nums,int sum,int k){
        int arrays = 0;
        int i=0;

        while(i<nums.length){
            int j=i;
            int currSum = 0;
            while(j<nums.length && nums[j]+currSum<=sum){
                currSum+=nums[j];
                j++;
            }
            arrays++;
            i=j;
        }

        return arrays<=k;
    }
}