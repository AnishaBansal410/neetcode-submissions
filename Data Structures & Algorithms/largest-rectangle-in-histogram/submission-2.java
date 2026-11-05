class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        Stack<Integer> st = new Stack<>();

        leftMax[0] = 0;

        rightMax[n-1] = n-1;

        st.push(0);

        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftMax[i] = 0;
            }
            else{
                leftMax[i] = st.peek()+1;
            }
            st.push(i);
        }

        st = new Stack<>();
        st.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightMax[i] = n-1;
            }
            else{
                rightMax[i] = st.peek()-1;
            }   
            st.push(i);
        }

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            ans = Math.max(ans,heights[i]*(rightMax[i]-leftMax[i]+1));
        }

        return ans;
    }
}
