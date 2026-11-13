class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> st = new Stack<>();

        int carry=1;

        int i=digits.length-1;

        while(i>=0){
            int sum=digits[i]+carry;
            int digit = sum%10;
            carry = sum/10;

            st.push(digit);
            i--;
        }

        if(carry>0){
            st.push(carry);
        }
        
        int[] ans = new int[st.size()];
        i=0;

        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }

        return ans;
    }
}
