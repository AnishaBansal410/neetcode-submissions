class Solution {

    boolean[] used;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        used = new boolean[nums.length];
        int sum=0;
        for(int i:nums){
            sum+=i;
        }

        if(sum%k!=0){
            return false;
        }

        sum = sum/k;

        return backtrack(nums,0,0,sum,k);
    }

    public boolean backtrack(int[] nums,int st,int sum,int target,int k){
        if(sum==target){
            return backtrack(nums,0,0,target,k-1);
        }

        if(k==0){
            return true;
        }

        for(int i=st;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(nums[i]>target){
                continue;
            }

            used[i]=true;
            if(backtrack(nums,i+1,sum+nums[i],target,k)){
                return true;
            }
            used[i]=false;
        }

        return false;
    }
}