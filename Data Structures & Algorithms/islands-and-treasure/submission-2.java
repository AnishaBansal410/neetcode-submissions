class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int land = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] direction : directions){
                int nx = direction[0]+curr[0];
                int ny = direction[1]+curr[1];

                if(nx<0 || ny<0 || nx>=grid.length || ny>= grid[0].length || grid[nx][ny]!=land){
                    continue;
                }
                q.offer(new int[]{nx,ny});
                grid[nx][ny] = grid[curr[0]][curr[1]]+1;
            }
        }
    }
}
