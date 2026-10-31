class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights[0].length;
        int m = heights.length;

        int[][] cost = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        cost[0][0]=0;

        pq.offer(new int[]{0,0,0});

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int w = curr[2];

            if(w>cost[r][c]){
                continue;
            }

            cost[r][c]=w;

            for(int[] d : directions){
                int nx = d[0]+r;
                int ny = d[1]+c;

                if(nx<0 || ny<0 || nx>=m || ny>=n){
                    continue;
                }

                int currWt = Math.max(cost[r][c] , Math.abs(heights[r][c]-heights[nx][ny]));

                if(currWt<cost[nx][ny]){
                    cost[nx][ny] = currWt;
                    pq.offer(new int[]{nx,ny,currWt});
                }
            }
        }

        return cost[m-1][n-1];
    }
}