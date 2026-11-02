class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());

        return ans;
    }

    public void backtrack(int[] nums, int st, List<Integer> tmp){

        ans.add(new ArrayList<>(tmp));

        for(int i=st;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if(used[i]){
                continue;
            }
            tmp.add(nums[i]);
            used[i]=true;
            backtrack(nums,i+1,tmp);
            used[i]=false;
            tmp.remove(tmp.size()-1);
        }
    }
}
