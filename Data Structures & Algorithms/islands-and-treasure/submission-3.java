class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] direction:directions){
                int nx=curr[0]+direction[0];
                int ny=curr[1]+direction[1];

                if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length||grid[nx][ny]==-1){
                    continue;
                }

                if(grid[nx][ny]==Integer.MAX_VALUE){
                    grid[nx][ny] = 1+grid[curr[0]][curr[1]];
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}
