class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0]=0;
        rightMax[0]=0;

        for(int i=1;i<height.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i-1]);
        }

        for(int i=height.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i+1]);
        }

        int ans=0;

        for(int i=0;i<height.length;i++){
            if(height[i]<Math.min(leftMax[i],rightMax[i])){
                ans+=Math.min(leftMax[i],rightMax[i])-height[i];
            }
        }

        return ans;
    }
}
