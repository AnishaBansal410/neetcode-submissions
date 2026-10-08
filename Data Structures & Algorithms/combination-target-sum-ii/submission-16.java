class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        // boolean[] visited = new boolean[candidates.length];
        combination(candidates,target,new ArrayList<>(),ans,0);
        return ans;
    }

    public void combination(int[] nums, int target,List<Integer> tmp,List<List<Integer>> ans,int st){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=st;i<nums.length;i++){
            if(i>st && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>target){
                break;
            }
            tmp.add(nums[i]);
            combination(nums,target-nums[i],tmp,ans,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
