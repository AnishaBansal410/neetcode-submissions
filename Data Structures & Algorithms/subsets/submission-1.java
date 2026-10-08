class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(ans,new ArrayList<>(),0,nums);
        return ans;
    }

    public void subset(List<List<Integer>> ans,List<Integer> tmp,int start,int[] nums){
        ans.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            subset(ans,tmp,i+1,nums);
            tmp.remove(tmp.size()-1);
        }
    }
}
