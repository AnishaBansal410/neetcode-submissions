class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        int perimeter = 0;
    
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    break;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] direction : directions){
                int nx = curr[0]+direction[0];
                int ny = curr[1]+direction[1];

                if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || grid[nx][ny]==0){
                    perimeter++;
                }
                else if(!visited[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }
            }
        }
        return perimeter;

    }
}