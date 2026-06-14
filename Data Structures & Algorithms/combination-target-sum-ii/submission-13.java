class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); 
        Arrays.sort(candidates);
        backtrack(candidates,0,new ArrayList<>(),ans,target);
        return ans;
    }

    public int sum(List<Integer> arr){
        int sum=0;
        for(Integer i:arr){
            sum+=i;
        }
        return sum;
    }

    public void backtrack(int[] nums,int start,List<Integer> tmp,List<List<Integer>> list,int target){
        if(target==0){
            list.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            tmp.add(nums[i]);
            backtrack(nums,i+1,tmp,list,target-nums[i]);
            tmp.remove(tmp.size()-1);
        }
    }
}
