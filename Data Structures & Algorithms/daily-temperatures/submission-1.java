class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        int j=temperatures.length-1;

        for(int i=temperatures.length-1;i>=0;i--){
            if(st.isEmpty()){
                ans[j--]=0;
                st.push(i);
                continue;
            }
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[j--]=0;
                st.push(i);
            }
            else{
                ans[j--]=st.peek()-i;
                st.push(i);
            }
        }

        return ans;
    }
}
