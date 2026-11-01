class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums,0,target,new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums,int st,int target,List<Integer> tmp){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=st;i<nums.length;i++){
            if(target<nums[i]){
                continue;
            }
            tmp.add(nums[i]);
            backtrack(nums,i,target-nums[i],tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
