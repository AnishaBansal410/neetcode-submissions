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

        sum = sum/k;

        Arrays.sort(nums);
        used = new boolean[nums.length];

        return subsets(nums,0,0,sum,k);
    }

    public boolean subsets(int[] nums,int st,int sum,int target,int k){
        if(sum==target){
            return subsets(nums,0,0,target,k-1);
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
            if(subsets(nums,i+1,sum+nums[i],target,k)){
                return true;
            }
            used[i]=false;
        }

        return false;
    }
}