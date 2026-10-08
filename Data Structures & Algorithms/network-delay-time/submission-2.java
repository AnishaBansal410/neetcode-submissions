class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(k>n || k<1){
            return -1;
        }

        int[] time = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] t : times){
            adj[t[0]-1].add(new int[]{t[1]-1,t[2]});
        }
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k-1]=0;
        pq.offer(new Node(k-1,0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(time[curr.vertex]<curr.dist){
                continue;
            }
            // time[curr.vertex]=curr.dist;
            for(int[] next : adj[curr.vertex]){
                if(time[next[0]]>next[1]+time[curr.vertex]){
                    time[next[0]]=next[1]+time[curr.vertex];
                    pq.offer(new Node(next[0],time[next[0]]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : time){
            if(i==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,i);
        }

        return max;
    }
}

class Node{
    int vertex;
    int dist;

    Node(int v,int d){
        this.vertex=v;
        this.dist=d;
        // this.wt=w;
    }
}
