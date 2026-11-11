class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        int m = heights.length;
        int n = heights[0].length;

        int[][] distance = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0,0,0});

        distance[0][0] = 0;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if(distance[r][c] < dist){
                continue;
            }

            distance[r][c] = dist;

            for(int[] d : directions){
                int nx = d[0]+r;
                int ny = d[1]+c;

                if(nx<0||ny<0||nx>=m||ny>=n){continue;}

                int x = Math.max(Math.abs(heights[r][c]-heights[nx][ny]),distance[r][c]);

                if(x<distance[nx][ny]){
                    distance[nx][ny] = x;
                    pq.offer(new int[]{nx,ny,x});
                }
            }
        }

        return distance[m-1][n-1];
    }
}