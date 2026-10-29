class Solution {

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!visited[i][j] && dfs(visited,i,j,board,word,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(boolean[][] visited,int i,int j,char[][] board,String word,int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(board[i][j]!=word.charAt(idx)){
            return false;
        }
        visited[i][j] = true;
        for(int[] d:directions){
            int nx = d[0]+i;
            int ny = d[1]+j;

            if(dfs(visited,nx,ny,board,word,idx+1)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }
}
