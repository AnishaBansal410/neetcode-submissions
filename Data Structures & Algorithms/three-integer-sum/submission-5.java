class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int i=0;

        while(i<nums.length){
            if(i>0 && nums[i]==nums[i-1]){
                i++;
                continue;
            }

            int curr = nums[i];

            int target = 0-nums[i];

            int j=i+1,k=nums.length-1;

            while(j<k){
                int sum = nums[j]+nums[k];

                if(sum==target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);

                    j++;

                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }

                    k--;
                    while(k>j && nums[k]==nums[k+1]){
                        k--;
                    }
                }

                else if(sum>target){
                    k--;
                }
                else{
                    j++;
                }
            }
            i++;
        }

        return ans;
    }
}
