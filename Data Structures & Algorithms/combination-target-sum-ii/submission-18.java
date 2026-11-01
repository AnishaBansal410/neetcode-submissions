class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backtrack(candidates,0,target,new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums,int st,int target,List<Integer> tmp){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=st;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if(nums[i]>target){
                break;
            }
            used[i]=true;
            tmp.add(nums[i]);
            backtrack(nums,i+1,target-nums[i],tmp);
            tmp.remove(tmp.size()-1);
            used[i]=false;
        }
    }
}
