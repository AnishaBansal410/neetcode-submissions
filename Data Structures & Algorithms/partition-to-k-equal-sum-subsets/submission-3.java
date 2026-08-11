class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%k!=0){
            return false;
        }
        sum = sum/k;
        boolean[] used = new boolean[nums.length];

        return subsets(used,nums,k,0,sum,0);
    }

    public boolean subsets(boolean[] used, int[] nums, int k,int sum,int target,int st){

        if(sum==target){
            return subsets(used,nums,k-1,0,target,0);
        }
        if(k==0){
            return true;
        }
        for(int i=st;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(nums[i]>target){
                break;
            }
            used[i]=true;;
            if(subsets(used,nums,k,sum+nums[i],target,i+1)){
                return true;
            }
            used[i]=false;
        }
        return false;
    }
}