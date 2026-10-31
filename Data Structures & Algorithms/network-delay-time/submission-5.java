class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] time = new int[n];

        List<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge:times){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            adj[u-1].add(new int[]{v-1,t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        Arrays.fill(time,Integer.MAX_VALUE);

        time[k-1]=0;

        pq.offer(new int[]{k-1,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];

            if(curr[1]>time[u]){
                continue;
            }

            time[u] = curr[1];

            for(int[] next : adj[u]){
                int v = next[0];
                int wt = next[1];

                if(time[u]+wt<time[v]){
                    time[v] = time[u]+wt;
                    pq.offer(new int[]{v,time[v]});
                }
            }
        }

        int ans=0;

        for(int i:time){
            if(i==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,i);
        }

        return ans;
    }
}
