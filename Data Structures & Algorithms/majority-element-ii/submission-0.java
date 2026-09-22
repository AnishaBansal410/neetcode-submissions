class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>nums.length/3){
                ans.add(e.getKey());
            }
        }

        return ans;
    }
}