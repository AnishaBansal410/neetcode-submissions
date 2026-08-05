class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            adj[times[i][0]-1].add(new Edge(times[i][1]-1,times[i][2]));
        }

        int[] time = new int[n];

        Arrays.fill(time,Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time-b.time);
        pq.offer(new Node(k-1,0));
        time[k-1] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(curr.time>time[curr.vertex]){
                continue;
            }

            for(Edge e : adj[curr.vertex]){
                int toVertex = e.toVertex;
                int weight = e.weight;

                if(weight+time[curr.vertex]<time[toVertex]){
                    time[toVertex] = weight + time[curr.vertex];
                    pq.offer(new Node(toVertex,time[toVertex]));
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(time[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,time[i]);
        }
        return ans;
    }
}
class Node{
    int vertex;
    int time;

    public Node(int v,int t){
        this.vertex=v;
        this.time=t;
    }
}

class Edge{
    int toVertex;
    int weight;

    public Edge(int v,int w){
        this.toVertex=v;
        this.weight=w;
    }
}
