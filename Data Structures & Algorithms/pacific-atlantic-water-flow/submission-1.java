class Solution {

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] visitedPacific = new boolean[n][m];
        boolean[][] visitedAtlantic = new boolean[n][m];

        for(int i=0;i<m;i++){
            if(!visitedPacific[0][i]){
                dfs(visitedPacific,heights,0,i);
            }
        }
        for(int i=0;i<m;i++){
            if(!visitedAtlantic[n-1][i]){
                dfs(visitedAtlantic,heights,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(!visitedPacific[i][0]){
                dfs(visitedPacific,heights,i,0);
            }
        }
        for(int i=0;i<n;i++){
            if(!visitedAtlantic[i][m-1]){
                dfs(visitedAtlantic,heights,i,m-1);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visitedPacific[i][j] && visitedAtlantic[i][j]){
                    ans.add(List.of(i,j));
                }
            }
        }

        return ans;
    }

    public void dfs(boolean[][] visited,int[][] heights,int i,int j){
        visited[i][j] = true;

        for(int[] d:directions){
            int nx = d[0]+i;
            int ny = d[1]+j;

            if(nx<0||ny<0||nx>=heights.length||ny>=heights[0].length||heights[nx][ny]<heights[i][j]){
                continue;
            }

            if(!visited[nx][ny]){
                dfs(visited,heights,nx,ny);
            }
        }
    }
}
