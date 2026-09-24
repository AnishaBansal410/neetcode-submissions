class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(map.containsKey(nums[i]) && Math.abs(i-map.get(nums[i]))<=k){
        //         return true;
        //     }
        //     map.put(nums[i],i);
        // }
        // return false;
        int i=0;
        while(i<nums.length){
            int j=i+1;
            while(j<nums.length && j-i<=k){
                if(nums[i]==nums[j]){
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }
}