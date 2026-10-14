class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // Every digit was 9, so the result needs one extra digit.
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
