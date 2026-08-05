class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);

        int[][] dist = new int[grid.length][grid[0].length];
        for(int[] i:dist){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        pq.offer(new int[]{0,0,grid[0][0]});
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            if(dist[curr[0]][curr[1]]<curr[2]){
                continue;
            }

            if(curr[0]==grid.length-1 && curr[1]==grid[0].length-1){
                return dist[curr[0]][curr[1]];
            }

            for(int[] direction : directions){
                int nx = direction[0]+curr[0];
                int ny = direction[1]+curr[1];

                if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length){
                    continue;
                }

                int newCost = Math.max(curr[2], grid[nx][ny]);

                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new int[]{nx, ny, newCost});
                }
            }
        }
        return -1;
    }
}
