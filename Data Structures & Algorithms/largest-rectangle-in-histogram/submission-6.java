class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        st.push(0);

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        left[0] = 0;
        right[heights.length-1]=heights.length-1;

        for(int i=1;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=0;
            }
            else{
                left[i]=st.peek()+1;
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            st.pop();
        }

        st.push(heights.length-1);

        for(int i=heights.length-2;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=heights.length-1;
            }
            else{
                right[i]=st.peek()-1;
            }
            st.push(i);
        }
        
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<heights.length;i++){
            ans = Math.max(ans,heights[i]*(right[i]-left[i]+1));
        }

        return ans;
    }
}
