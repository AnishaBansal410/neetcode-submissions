class Solution {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        
        used = new boolean[nums.length];

        backtrack(nums,new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums,List<Integer> tmp){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
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
