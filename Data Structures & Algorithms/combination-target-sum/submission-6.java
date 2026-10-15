class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,ans,new ArrayList<>(),target);

        return ans;
    }

    public void backtrack(int[] nums,int start,List<List<Integer>> ans,List<Integer> tmp,int target){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(nums[i]>target){
                break;
            }
            tmp.add(nums[i]);
            backtrack(nums,i,ans,tmp,target-nums[i]);
            tmp.remove(tmp.size()-1);
        }
    }
}
