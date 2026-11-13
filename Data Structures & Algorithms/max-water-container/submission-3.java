class Solution {
    public int maxArea(int[] heights) {
        int st=0,end=heights.length-1;
        int ans=0;
        while(st<end){
            ans = Math.max(ans,(end-st)*Math.min(heights[st],heights[end]));

            if(heights[st]>heights[end]){
                end--;
            }
            else{
                st++;
            }
        }

        return ans;
    }
}
