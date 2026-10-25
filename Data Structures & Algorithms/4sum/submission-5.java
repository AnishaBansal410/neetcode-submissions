class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;

            while (j < n - 2) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                long curr = (long) target - nums[i] - nums[j];
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[k] + nums[l];

                    if (sum < curr) {
                        k++;
                    } else if (sum > curr) {
                        l--;
                    } else {
                        ans.add(Arrays.asList(
                            nums[i], nums[j], nums[k], nums[l]
                        ));

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }

                j++;
            }
        }

        return ans;
    }
}