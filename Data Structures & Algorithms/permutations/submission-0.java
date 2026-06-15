class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int[] nums,int start,List<Integer> idx,List<Integer> tmp,List<List<Integer>> ans){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(idx.contains(i)){
                continue;
            }
            tmp.add(nums[i]);
            idx.add(i);
            backtrack(nums,0,idx,tmp,ans);
            tmp.remove(tmp.size()-1);
            idx.remove(idx.size()-1);
        }
    }
}
