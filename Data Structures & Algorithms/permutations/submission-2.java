class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int[] nums,boolean[] idx,List<Integer> tmp,List<List<Integer>> ans){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(idx[i]){
                continue;
            }
            tmp.add(nums[i]);
            idx[i]=true;
            backtrack(nums,idx,tmp,ans);
            tmp.remove(tmp.size()-1);
            idx[i]=false;
        }
    }
}
