class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int i=0;
        int max=0;
        while(i<prices.length-1){
            max=Math.max(max,prices[i+1]-prices[i]);
            ans+=max;
            if(max==prices[i+1]-prices[i]){
                max=0;
            }
            i++;
        }
        return ans;
    }
}