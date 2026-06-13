class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,new ArrayList<Integer>(),ans,target);
        return ans;
    }

    public void backtrack(int[] nums,int st,List<Integer> tmpList,List<List<Integer>> ans,int target){
        if(sum(tmpList)==target){
            ans.add(new ArrayList<>(tmpList));
        }
        if(sum(tmpList)>target){
            return;
        }
        for(int i=st;i<nums.length;i++){
            tmpList.add(nums[i]);
            backtrack(nums,i,tmpList,ans,target);
            tmpList.remove(tmpList.size()-1);
        }
    }

    public int sum(List<Integer> list){
        int sum=0;
        for(Integer i:list){
            sum+=i;
        }
        return sum;
    }
}
