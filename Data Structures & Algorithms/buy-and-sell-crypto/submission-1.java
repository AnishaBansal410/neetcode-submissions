class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int i=0;
        while(i<prices.length){
            int j=i+1;
            while(j<prices.length && prices[j]>prices[i]){
                maxProfit = Math.max(prices[j]-prices[i],maxProfit);
                j++;
            }
            i=j;
        }
        return maxProfit;
    }
}
