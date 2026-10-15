class Solution {
    int res=0;

    public int subsetXORSum(int[] nums) {
        xor(nums,0,new ArrayList<>());
        return res;
    }

    public void xor(int[] nums,int start,List<Integer> arr){
        int xorr=0;
        for(int i:arr){
            xorr^=i;
        }
        res+=xorr;
        for(int i=start;i<nums.length;i++){
            arr.add(nums[i]);
            xor(nums,i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}