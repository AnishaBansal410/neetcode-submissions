class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums,new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums,List<Integer> tmp){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if(used[i]){
                continue;
            }
            used[i]=true;
            tmp.add(nums[i]);
            backtrack(nums,tmp);
            tmp.remove(tmp.size()-1);
            used[i]=false;
        }
    }
}