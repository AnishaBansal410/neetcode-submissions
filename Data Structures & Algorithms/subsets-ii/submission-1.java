class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(ans,new ArrayList<>(),0,nums,used);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans,List<Integer> tmp,int start,int[] nums,boolean[] used){
        ans.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1] && !used[i]){
                continue;
            }
            used[i]=true;
            tmp.add(nums[i]);
            backtrack(ans,tmp,i+1,nums,used);
            used[i]=false;
            tmp.remove(tmp.size()-1);
        }
    }
}
