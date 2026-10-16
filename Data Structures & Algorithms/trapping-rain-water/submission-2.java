class Solution {
    public int trap(int[] heights) {
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        leftMax[0] = heights[0];
        for(int i=1;i<heights.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],heights[i]);
        }

        rightMax[heights.length-1] = heights[heights.length-1];
        for(int i=heights.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],heights[i]);
        }

        int ans=0;

        for(int i=0;i<heights.length;i++){
            if(heights[i]<Math.min(leftMax[i],rightMax[i])){
                ans+=Math.min(leftMax[i],rightMax[i])-heights[i];
            }
        }

        return ans;
    }
}
