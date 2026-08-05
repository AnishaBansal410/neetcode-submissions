class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int i=0;
        while(i<prices.length){
            int j=i+1;
            while(j<prices.length && prices[j]>prices[j-1]){
                ans+=prices[j]-prices[j-1];
                j++;
            }
            i=j;
        }
        return ans;
    }
}