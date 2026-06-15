class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] idx = new boolean[nums.length];
        backtrack(nums,idx,new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int[] nums,boolean[] idx,List<Integer> tmp,List<List<Integer>> ans){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1]==nums[i] && !idx[i-1]){
                continue;
            }
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