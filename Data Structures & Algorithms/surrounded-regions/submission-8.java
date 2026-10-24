class Solution {
    public void solve(char[][] board) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                dfs(board,directions,0,i);
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(board[board.length-1][i]=='O'){
                dfs(board,directions,board.length-1,i);
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                dfs(board,directions,i,0);
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][board[0].length-1]=='O'){
                dfs(board,directions,i,board[0].length-1);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }
    

    public void dfs(char[][] board,int[][] directions,int i,int j){
        board[i][j]='#';
        for(int[] d:directions){
            int nx=d[0]+i;
            int ny=d[1]+j;

            if(nx<0||ny<0||nx>=board.length||ny>=board[0].length||board[nx][ny]!='O'){
                continue;
            }
            if(board[nx][ny]=='O'){
                dfs(board,directions,nx,ny);
            }
        }
    }
}
