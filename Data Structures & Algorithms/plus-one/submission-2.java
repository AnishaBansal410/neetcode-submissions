class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> st = new Stack<>();
        int carry=1;
        
        for(int i=digits.length-1;i>=0;i--){
            int sum = digits[i]+carry;
            carry = sum/10;
            st.push(sum%10);
            if(carry==0){
                i--;
                while(i>=0){
                    st.push(digits[i]);
                    i--;
                }
                break;
            }
        }
        if(carry>0){
            st.push(carry);
        }
        int[] ans = new int[st.size()];

        for(int i=0;i<ans.length;i++){
            ans[i]=st.pop();
        }
        return ans;
    }
}
