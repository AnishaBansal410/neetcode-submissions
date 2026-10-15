class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,ans,new ArrayList<>(),k);
        return ans;
    }

    public void backtrack(int[] nums,int start,List<List<Integer>> ans,List<Integer> tmp,int k){
        if(tmp.size()==k){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            backtrack(nums,i+1,ans,tmp,k);
            tmp.remove(tmp.size()-1);
        }
    }
}