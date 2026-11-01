class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,new ArrayList<>(),0);
        return ans;
    }

    public void backtrack(int[] nums,List<Integer> tmp,int st){
        ans.add(new ArrayList<>(tmp));
        for(int i=st;i<nums.length;i++){
            tmp.add(nums[i]);
            backtrack(nums,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
