class Solution {
    int res=0;
    public int subsetXORSum(int[] nums) {
        backtrack(nums,0,new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums,int st,List<Integer> tmp){
        int xor=0;
        for(int i:tmp){
            xor^=i;
        }
        res+=xor;
        for(int i=st;i<nums.length;i++){
            tmp.add(nums[i]);
            backtrack(nums,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}