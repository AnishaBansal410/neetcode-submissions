class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        dist[0][0]=0;

        pq.offer(new int[]{0,0,0});

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r=curr[0];
            int c=curr[1];
            int wt=curr[2];

            if(dist[r][c]<wt){
                continue;
            }
            dist[r][c]=wt;
            for(int[] d:directions){
                int nx=d[0]+r;
                int ny=d[1]+c;

                if(nx<0||ny<0||nx>=m||ny>=n){
                    continue;
                }

                int currWt = Math.max(wt,Math.abs(heights[nx][ny]-heights[r][c]));

                if(currWt<dist[nx][ny]){
                    dist[nx][ny]=currWt;
                    pq.offer(new int[]{nx,ny,currWt});
                }
            }
        }

        return dist[m-1][n-1];
    }
}
