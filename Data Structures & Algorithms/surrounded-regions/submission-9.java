class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][board[0].length-1]=='O'){
                dfs(board,i,board[0].length-1);
            }
        }

        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[board.length-1][i]=='O'){
                dfs(board,board.length-1,i);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(char[][] board,int i,int j){
        board[i][j]='#';

        for(int[] d:directions){
            int nx=d[0]+i;
            int ny=d[1]+j;

            if(nx<0||ny<0||nx>=board.length||ny>=board[0].length||board[nx][ny]!='O'){
                continue;
            }

            dfs(board,nx,ny);
        }
    }
}
