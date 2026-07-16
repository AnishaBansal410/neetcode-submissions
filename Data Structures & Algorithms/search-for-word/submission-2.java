class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,visited,i,j,directions,0,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board,boolean[][] visited,int i,int j,int[][] directions,int k,String word){
        if(k==word.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return false;
        }
        if (visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        visited[i][j]=true;
        for(int[] direction:directions){
            int nx = direction[0]+i;
            int ny = direction[1]+j;

            if(search(board,visited,nx,ny,directions,k+1,word)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }
}
