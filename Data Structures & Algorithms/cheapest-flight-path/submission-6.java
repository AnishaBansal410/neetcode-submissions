class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;

        for(int i=0;i<=k;i++){
            int[] tmp = price.clone();

            for(int[] flight : flights){
                int st = flight[0];
                if(price[st]==Integer.MAX_VALUE){
                    continue;
                }

                int end = flight[1];
                int cost = flight[2];

                if(cost+price[st]<tmp[end]){
                    tmp[end]=cost+price[st];
                }
            }
            price=tmp;
        }

        if(price[dst]==Integer.MAX_VALUE){
            return -1;
        }

        return price[dst];
    }
}
