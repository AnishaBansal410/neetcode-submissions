class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;

        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int i=0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j=i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);

                adj.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{dist,i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        Set<Integer> visit = new HashSet<>();

        pq.offer(new int[]{0,0});
        int res=0;

        while(visit.size()<n){
            int[] curr = pq.poll();

            if(visit.contains(curr[1])){
                continue;
            }

            res+=curr[0];

            visit.add(curr[1]);

            for(int[] nei : adj.getOrDefault(curr[1],Collections.emptyList())){

                if(!visit.contains(nei[1])){
                    pq.offer(nei);
                }
            }
        }

        return res;
    }
}
