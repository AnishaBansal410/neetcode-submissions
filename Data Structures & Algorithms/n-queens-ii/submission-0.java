class Solution {

    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> negDiag = new HashSet<>();
    int ans=0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,n,board);
        return ans;
    }

    public void backtrack(int r,int n,char[][] board){
        if(r==n){
            ans++;
            return;
        }

        for(int c=0;c<n;c++){
            if(col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)){
                continue;
            }

            board[r][c]='Q';
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            backtrack(r+1,n,board);
            board[r][c]='.';
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }
    }
}