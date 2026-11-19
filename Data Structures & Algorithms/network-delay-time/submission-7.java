class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] t:times){
            adj[t[0]-1].add(new int[]{t[1]-1,t[2]});
        }

        int[] time = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k-1]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.offer(new int[]{k-1,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            if(time[curr[0]]<curr[1]){
                continue;
            }

            time[curr[0]]=curr[1];

            for(int[] next:adj[curr[0]]){
                int v = next[0];
                int wt = next[1];

                if(wt+curr[1]<time[v]){
                    time[v]=wt+curr[1];
                    pq.offer(new int[]{v,wt+curr[1]});
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
