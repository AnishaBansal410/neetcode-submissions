class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        int perimeter=0;

        Queue<int[]> q = new ArrayDeque<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] direction : directions){
                            int nx = curr[0]+direction[0];
                            int ny = curr[1]+direction[1];

                            if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || grid[nx][ny]==0){
                                perimeter++;
                                continue;
                            }
                            if(!visited[nx][ny]){
                                visited[nx][ny]=true;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}