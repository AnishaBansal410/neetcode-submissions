class Solution {
    public int orangesRotting(int[][] grid) {
        int ans=0;
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
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
        if(fresh==0){
            return 0;
        }
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] curr = q.poll();
                for(int[] direction:directions){
                    int nx=direction[0]+curr[0];
                    int ny=direction[1]+curr[1];
                    if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length||grid[nx][ny]==0||grid[nx][ny]==2){
                        continue;
                    }
                    grid[nx][ny]=2;
                    fresh--;
                    q.offer(new int[]{nx,ny});
                    
                }
            }
            ans++;
        }
        if(fresh!=0){
            return -1;
        }
        return ans;
    }
}
