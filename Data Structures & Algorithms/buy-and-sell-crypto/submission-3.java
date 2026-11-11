class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;

        int i=0;

        while(i<prices.length){
            int j = i+1;
            
            while(j<prices.length && prices[j]>prices[i]){
                profit=Math.max(profit,prices[j]-prices[i]);
                j++;
            }

            i=j;
        }

        return profit;
    }
}
