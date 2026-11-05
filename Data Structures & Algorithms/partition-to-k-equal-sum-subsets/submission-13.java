class Solution {
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%k!=0){
            return false;
        }
        used = new boolean[nums.length];
        sum=sum/k;

        return backtrack(nums,0,sum,0,k);
    }

    public boolean backtrack(int[] nums,int sum,int target,int idx,int k){
        if(sum==target){
            return backtrack(nums,0,target,0,k-1);
        }
        if(k==0){
            return true;
        }

        for(int i=idx;i<nums.length;i++){
            if(used[i] || sum+nums[i]>target){
                continue;
            }
            used[i]=true;
            if(backtrack(nums,sum+nums[i],target,i+1,k)){
                return true;
            }
            used[i]=false;
        }

        return false;
    }
}