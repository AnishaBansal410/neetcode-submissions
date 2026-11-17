class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int profit=0;

        while(i<prices.length){
            int j=i+1;
            while(j<prices.length && prices[i]<prices[j]){
                profit+=prices[j]-prices[i];
                i++;j++;
            }
            i=j;
        }

        return profit;
    }
}