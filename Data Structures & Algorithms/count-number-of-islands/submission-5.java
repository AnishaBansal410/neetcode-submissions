class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(visited,i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(boolean[][] visited,int i,int j,char[][] grid){
        visited[i][j]=true;

        for(int[] direction:directions){
            int nx = direction[0]+i;
            int ny = direction[1]+j;

            if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || grid[nx][ny]=='0'){
                continue;
            }

            if(!visited[nx][ny]){
                dfs(visited,nx,ny,grid);
            }
        }
    }
}
