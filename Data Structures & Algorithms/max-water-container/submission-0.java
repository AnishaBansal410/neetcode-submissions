class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int i=0,j=heights.length-1;
        while(i<j){
            max=Math.max(max,Math.min(heights[i],heights[j])*(j-i));
            if(heights[i]>heights[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
    }
}
