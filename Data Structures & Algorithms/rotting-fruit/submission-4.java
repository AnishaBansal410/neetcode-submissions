class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int fresh=0;

        Queue<int[]> q = new ArrayDeque<>();

        int minutes=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] curr = q.poll();

                for(int[] d :directions){
                    int nx=d[0]+curr[0];
                    int ny=d[1]+curr[1];

                    if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || grid[nx][ny]==0 || grid[nx][ny]==2){
                        continue;
                    }

                    grid[nx][ny]=2;
                    fresh--;
                    q.offer(new int[]{nx,ny});
                }
            }

            minutes++;
        }

        if(fresh>0){
            return -1;
        }

        return minutes;
    }
}
