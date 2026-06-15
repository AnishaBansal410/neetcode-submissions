class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int[] nums,int start,ArrayList<Integer> tmp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i-1]==nums[i]){
                continue;
            }
            tmp.add(nums[i]);
            backtrack(nums,i+1,tmp,ans);
            tmp.remove(tmp.size()-1);
        }
    }
}
