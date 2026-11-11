class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] time : times){
            int u = time[0]-1;
            int v = time[1]-1;
            int wt = time[2];

            adj[u].add(new int[]{v,wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.offer(new int[]{k-1,0});

        int[] time = new int[n];

        Arrays.fill(time,Integer.MAX_VALUE);

        time[k-1]=0;

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int v = curr[0];
            int t = curr[1];

            if(time[v]<t){
                continue;
            }

            time[v] = t;

            for(int[] next : adj[v]){
                if(next[1]+t < time[next[0]]){
                    time[next[0]] = next[1]+t;
                    pq.offer(new int[]{next[0],next[1]+t});
                }
            }
        }

        int max=0;

        for(int i:time){
            if(i==Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(i,max);
        }

        return max;
    }
}
