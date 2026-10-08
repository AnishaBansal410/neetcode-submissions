class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        combination(ans,new ArrayList<>(),target,nums,0);
        return ans;
    }

    public void combination(List<List<Integer>> ans,List<Integer> tmp,int target,int[] nums,int st){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // if(target<0){
        //     return;
        // }
        for(int i=st;i<nums.length;i++){
            if(nums[i]>target){
                break;
            }
            tmp.add(nums[i]);
            combination(ans,tmp,target-nums[i],nums,i);
            tmp.remove(tmp.size()-1);
        }
    }
}
