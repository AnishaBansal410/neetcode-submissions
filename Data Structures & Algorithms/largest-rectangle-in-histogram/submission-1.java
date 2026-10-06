class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        leftMax[0] = 0;
        rightMax[heights.length-1] = heights.length-1;

        st.push(0);

        for(int i=1;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftMax[i]=0;
            }
            else{
                leftMax[i]=st.peek()+1;
            }
            st.push(i);
        }

        st = new Stack<>();
        st.push(heights.length-1);
        for(int i=heights.length-2;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightMax[i]=heights.length-1;
            }
            else{
                rightMax[i]=st.peek()-1;
            }
            st.push(i);
        }

        int ans=0;

        for(int i=0;i<heights.length;i++){
            ans = Math.max(ans, heights[i]*(rightMax[i]-leftMax[i]+1));
        }

        return ans;
    }
}
