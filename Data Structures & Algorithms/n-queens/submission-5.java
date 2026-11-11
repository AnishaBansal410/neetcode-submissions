class Solution {
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> negDiag = new HashSet<>();

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        backtrack(0,n,board);
        return ans;
    }

    public void backtrack(int r,int n,char[][] board){
        if(r==n){
            List<String> tmp = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    sb.append(board[i][j]);
                }
                tmp.add(sb.toString());
            }
            ans.add(tmp);
        }

        for(int i=0;i<board[0].length;i++){
            if(col.contains(i) || posDiag.contains(r+i) || negDiag.contains(r-i)){
                continue;
            }
            board[r][i] = 'Q';
            col.add(i);
            posDiag.add(r+i);
            negDiag.add(r-i);
            backtrack(r+1,n,board);
            board[r][i]='.';
            col.remove(i);
            posDiag.remove(r+i);
            negDiag.remove(r-i);
        }
    }
}
