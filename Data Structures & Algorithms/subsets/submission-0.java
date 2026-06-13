class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int[] nums,int st,ArrayList<Integer> tmpList,List<List<Integer>> list){
        list.add(new ArrayList<>(tmpList));
        for(int i=st;i<nums.length;i++){
            tmpList.add(nums[i]);
            backtrack(nums,i+1,tmpList,list);
            tmpList.remove(tmpList.size()-1);
        }
    }
}
