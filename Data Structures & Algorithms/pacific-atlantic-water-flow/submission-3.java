class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];
        boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];

        for(int i=0;i<heights.length;i++){
            if(!visitedPacific[i][0]){
                dfs(heights,i,0,visitedPacific);
            }
        }
        for(int i=0;i<heights.length;i++){
            if(!visitedAtlantic[i][heights[0].length-1]){
                dfs(heights,i,heights[0].length-1,visitedAtlantic);
            }
        }
        for(int i=0;i<heights[0].length;i++){
            if(!visitedPacific[0][i]){
                dfs(heights,0,i,visitedPacific);
            }
        }
        for(int i=0;i<heights[0].length;i++){
            if(!visitedAtlantic[heights.length-1][i]){
                dfs(heights,heights.length-1,i,visitedAtlantic);
            }
        }

        List<List<Integer>> arr = new ArrayList<>();

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(visitedPacific[i][j] && visitedAtlantic[i][j]){
                    List<Integer> tmp = new ArrayList<>(Arrays.asList(i,j));
                    // tmp.add(i);
                    // tmp.add(j);
                    arr.add(tmp);
                }
            }
        }

        return arr;
    }

    public void dfs(int[][] heights,int i,int j,boolean[][] visited){
        visited[i][j]=true;

        for(int[] d : directions){
            int nx = i+d[0];
            int ny = j+d[1];

            if(nx<0 || ny<0 || nx>=heights.length || ny>=heights[0].length || heights[nx][ny]<heights[i][j]){
                continue;
            }

            if(!visited[nx][ny]){
                dfs(heights,nx,ny,visited);
            }
        }
    }
}
