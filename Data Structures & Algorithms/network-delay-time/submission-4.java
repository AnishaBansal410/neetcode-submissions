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
            if(curr[1]>time[curr[0]]){
                continue;
            }
            time[curr[0]] = curr[1];

            for(int[] next : adj[curr[0]]){
                if(time[curr[0]]+next[1]<time[next[0]]){
                    time[next[0]] = time[curr[0]]+next[1];
                    pq.offer(new int[]{next[0],time[next[0]]});
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
