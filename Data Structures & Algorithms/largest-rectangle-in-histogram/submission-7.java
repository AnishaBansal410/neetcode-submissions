class Solution {
    public int largestRectangleArea(int[] heights) {

        int n=heights.length;
        Stack<Integer> st = new Stack<>();

        int[] left = new int[n];
        int[] right = new int[n];

        left[0]=0;
        right[n-1]=n-1;

        st.push(0);

        for(int i=1;i<n;i++){
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
        
        st.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=n-1;
            }
            else{
                right[i]=st.peek()-1;
            }
            st.push(i);
        }

        int ans=0;

        for(int i=0;i<n;i++){
            ans=Math.max(ans,heights[i]*(right[i]-left[i]+1));
        }

        return ans;
    }
}
