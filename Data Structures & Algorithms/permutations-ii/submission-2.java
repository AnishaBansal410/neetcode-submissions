class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(ans,new ArrayList<>(),nums,used);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans,List<Integer> tmp,int[] nums,boolean[] used){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if(used[i]){
                continue;
            }
            tmp.add(nums[i]);
            used[i]=true;
            backtrack(ans,tmp,nums,used);
            used[i]=false;
            tmp.remove(tmp.size()-1);
        }
    }
}