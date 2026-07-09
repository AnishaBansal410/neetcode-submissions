class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return dfs(grid,visited,i,j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, boolean[][] visited, int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
            return 1;
        }
        if(visited[r][c]==true){
            return 0;
        }
        visited[r][c]=true;
        return dfs(grid,visited,r+1,c)+dfs(grid,visited,r-1,c)+dfs(grid,visited,r,c+1)+dfs(grid,visited,r,c-1);
    }
}