class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans=0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,i,j,visited,directions);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid,int i,int j,boolean[][] visited,int[][] directions){
        visited[i][j]=true;
        for(int[] direction:directions){
            int nx=direction[0]+i;
            int ny=direction[1]+j;
            if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length||grid[nx][ny]=='0'){
                continue;
            }
            else if(!visited[nx][ny]){
                // visited[nx][ny]=true;
                dfs(grid,nx,ny,visited,directions);
            }
        }
    }
}
