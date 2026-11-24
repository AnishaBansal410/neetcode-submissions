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

        sum=sum/k;

        return partition(nums,0,0,sum,k);
    }

    public boolean partition(int[] nums,int idx,int sum,int target,int k){
        if(sum==target){
            return partition(nums,0,0,target,k-1);
        }
        if(k==0){
            return true;
        }

        for(int i=idx;i<nums.length;i++){
            if(nums[i]>target || used[i]){
                continue;
            }
            used[i]=true;
            if(partition(nums,i+1,sum+nums[i],target,k)){
                return true;
            }
            used[i]=false;
        }

        return false;
    }
}