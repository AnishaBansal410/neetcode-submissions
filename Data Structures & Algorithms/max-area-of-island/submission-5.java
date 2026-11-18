class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    Queue<int[]> q = new ArrayDeque<>();
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                    int area=1;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] d : directions){
                            int nx = d[0]+curr[0];
                            int ny = d[1]+curr[1];

                            if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || grid[nx][ny]==0){
                                continue;
                            }

                            if(!visited[nx][ny]){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny]=true;
                                area++;
                            }
                        }
                    }
                    maxArea=Math.max(area,maxArea);
                }
            }
        }

        return maxArea;
    }
}
