class Solution {

    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        backtrack(0,n,board);

        return res;
    }

    public void backtrack(int r,int n, char[][] board){
        if(r==n){
            List<String> tmp = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append(board[i][j]);
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
        }

        for(int c=0;c<n;c++){
            if(col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)){
                continue;
            }
            board[r][c] = 'Q';
            posDiag.add(r+c);
            negDiag.add(r-c);
            col.add(c);
            backtrack(r+1,n,board);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            col.remove(c);
            board[r][c]='.';
        }
    }
}
