class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;

        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int i=0;i<N;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j=i+1;j<N;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);

                adj.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{dist,i});
            }
        }

        int res=0;

        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<Integer> visit = new HashSet<>();

        min.offer(new int[]{0,0});

        while(visit.size()<N){
            int[] curr = min.poll();
            int cost = curr[0];
            int node = curr[1];

            if(visit.contains(node)){
                continue;
            }

            res+=cost;

            visit.add(node);

            for(int[] neighbor : adj.getOrDefault(node,Collections.emptyList())){
                int ncost = neighbor[0];
                int n = neighbor[1];

                if(!visit.contains(n)){
                    min.offer(new int[]{ncost,n});
                }
            }
        }

        return res;
    }
}
