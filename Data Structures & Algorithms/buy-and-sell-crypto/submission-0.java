class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int i=0;
        while(i<prices.length){
            int j=i+1;
            while(j<prices.length && prices[j]>prices[i]){
                ans=Math.max(prices[j]-prices[i],ans);
                j++;
            }
            i=j;
        }
        return ans;
    }
}
