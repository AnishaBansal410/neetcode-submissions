class Solution {

    boolean[][] visited;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;

        visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && dfs(board,i,j,word,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board,int i,int j, String s, int idx){

        if(idx==s.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length || j>=board[0].length || board[i][j]!=s.charAt(idx)){
            return false;
        }
           
        if(visited[i][j]){
            return false;
        }

        visited[i][j] = true;

        for(int[] d : directions){
            int nx = d[0]+i;
            int ny = d[1]+j;

            if(dfs(board,nx,ny,s,idx+1)){
                return true;
            }
        }

        visited[i][j]=false;
        return false;
    }
}
