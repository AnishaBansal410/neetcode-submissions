class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;

        List<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] flight:flights){
            adj[flight[0]].add(new int[]{flight[1],flight[2]});
        }

        for(int i=0;i<=k;i++){
            int[] tmp = price.clone();

            for(int[] flight:flights){
                if(price[flight[0]]==Integer.MAX_VALUE){
                    continue;
                }
                int curr = price[flight[0]]+flight[2];
                if(curr<tmp[flight[1]]){
                    tmp[flight[1]]=curr;
                }
            }

            price=tmp;
        }

        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}
