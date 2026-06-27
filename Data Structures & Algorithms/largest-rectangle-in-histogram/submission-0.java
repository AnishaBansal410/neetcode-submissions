class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] pre = new int[heights.length];
        int[] post = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pre[i]=0;
            }
            else{
                pre[i]=st.peek()+1;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                post[i]=heights.length-1;
            }
            else{
                post[i]=st.peek()-1;
            }
            st.push(i);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            ans=Math.max(ans,(post[i]-pre[i]+1)*heights[i]);
        }
        return ans;
    }
}
