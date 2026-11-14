class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i,j});

                    grid[i][j]='0';

                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        for(int[] d:directions){
                            int nx = d[0]+curr[0];
                            int ny = d[1]+curr[1];

                            if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length){
                                continue;
                            }
                            if(grid[nx][ny]=='1'){
                                grid[nx][ny]='0';
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                    islands++;
                }
            }
        }

        return islands;
    }
}
