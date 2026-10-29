class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);

        price[src]=0;

        List<Integer>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] flight:flights){
            int u = flight[0];
            int v = flight[1];

            adj[u].add(v);
        }

        for(int i=0;i<=k;i++){
            int[] tmp = price.clone();

            for(int[] edge:flights){
                if(price[edge[0]]==Integer.MAX_VALUE){
                    continue;
                }
                int u = edge[0];
                int v = edge[1];
                int p = edge[2];
                
                if(price[u]+p<tmp[v]){
                    tmp[v] = price[u]+p;
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
