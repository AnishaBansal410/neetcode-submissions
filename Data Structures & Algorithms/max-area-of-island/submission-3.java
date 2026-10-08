class Solution {
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    int area=1;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] neighbor : directions){
                            int nx = curr[0]+neighbor[0];
                            int ny = curr[1]+neighbor[1];

                            if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length ||                            grid[nx][ny]==0){
                                continue;
                            }

                            if(!visited[nx][ny]){
                              area++;
                              q.offer(new int[]{nx,ny});
                              visited[nx][ny]=true;
                            }
                        }
                    }
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, boolean[][] visited, int i, int j){
        visited[i][j]=true;
        int area=0;
        for(int[] neighbor : directions){
            int nx = i+neighbor[0];
            int ny = j+neighbor[1];

            if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || grid[nx][ny]==0){
                continue;
            }

            if(!visited[nx][ny]){
               area+=1+dfs(grid,visited,nx,ny);
            }
        }

        return area;
    }
}
