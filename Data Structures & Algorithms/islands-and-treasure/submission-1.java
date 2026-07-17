class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int[] direction:directions){
                    int nx=direction[0]+curr[0];
                    int ny=direction[1]+curr[1];
                    if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length||grid[nx][ny]==-1){
                        continue;
                    }
                    else if(grid[nx][ny]==2147483647){
                        grid[nx][ny]=Math.min(grid[nx][ny],grid[curr[0]][curr[1]]+1);
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
