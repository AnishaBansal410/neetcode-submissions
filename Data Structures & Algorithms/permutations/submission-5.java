class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,ans,new ArrayList<>(),used);
        return ans;
    }

    public void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> tmp,boolean[] used){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;
            tmp.add(nums[i]);
            backtrack(nums,ans,tmp,used);
            tmp.remove(tmp.size()-1);
            used[i]=false;
        }
    }
}
