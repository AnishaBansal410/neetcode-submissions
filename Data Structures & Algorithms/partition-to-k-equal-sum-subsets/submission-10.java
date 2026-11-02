class Solution {

    int ct=0;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum=0;
        for(int i:nums){
            sum+=i;
        }

        if(sum%k!=0){
            return false;
        }

        sum = sum/k;

        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        return backtrack(used,nums,0,sum,0,k);
    }

    public boolean backtrack(boolean[] used,int[] nums,int sum,int target,int st,int k){
        
        if(sum==target){
            return backtrack(used,nums,0,target,0,k-1);
        }

        if(k==0){
            return true;
        }

        for(int i=st;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(nums[i] > target){
                break;
            }
            used[i] = true;
            if(backtrack(used,nums,sum+nums[i],target,i+1,k)){
                return true;
            }
            used[i]=false;
        }
        return false;
    }
}