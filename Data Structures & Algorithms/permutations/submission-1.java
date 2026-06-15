class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int[] nums,List<Integer> idx,List<Integer> tmp,List<List<Integer>> ans){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(idx.contains(i)){
                continue;
            }
            tmp.add(nums[i]);
            idx.add(i);
            backtrack(nums,idx,tmp,ans);
            tmp.remove(tmp.size()-1);
            idx.remove(idx.size()-1);
        }
    }
}
