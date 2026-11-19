class Solution {
    boolean[][] visited;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board,String word,int idx,int i,int j){
        if(idx==word.length()){
            return true;
        }

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || board[i][j]!=word.charAt(idx)){
            return false;
        }

        visited[i][j]=true;

        for(int[] d:directions){
            int nx = d[0]+i;
            int ny = d[1]+j;

            if(dfs(board,word,idx+1,nx,ny)){
                return true;
            }
        }

        visited[i][j]=false;

        return false;
    }
}
