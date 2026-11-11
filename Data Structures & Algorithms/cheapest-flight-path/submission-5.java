class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] cost = new int[n];

        Arrays.fill(cost,Integer.MAX_VALUE);

        cost[src]=0;
        
        for(int i=0;i<=k;i++){
            int[] tmp = cost.clone();
            for(int[] flight:flights){

                int u = flight[0];

                if(cost[u]==Integer.MAX_VALUE){
                    continue;
                }

                int v = flight[1];
                int wt = flight[2];

                if(tmp[v]>wt+cost[u]){
                    tmp[v] = wt+cost[u];
                }
            }
            cost = tmp;
        }
            

        return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
