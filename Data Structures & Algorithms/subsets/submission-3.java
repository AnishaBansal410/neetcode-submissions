class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,ans,new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums,int start,List<List<Integer>> ans,List<Integer> tmp){
        ans.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            backtrack(nums,i+1,ans,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
