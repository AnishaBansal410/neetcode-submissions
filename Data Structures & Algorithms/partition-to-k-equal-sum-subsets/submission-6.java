class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%k!=0){
            return false;
        }
        sum = sum/k;
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        return backtrack(used,nums,0,sum,k,0);

    }

    public boolean backtrack(boolean[] used,int[] nums,int sum,int target,int k,int st){
        if(sum==target){
            return backtrack(used,nums,0,target,k-1,0);
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
            used[i]=true;
            if(backtrack(used,nums,sum+nums[i],target,k,i+1)){
                return true;
            }
            used[i]=false;
        }

        return false;
    }
}