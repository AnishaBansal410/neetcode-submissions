class Solution {

    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> negDiag = new HashSet<>();
    
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,n,board);
        return ans;
    }

    public void backtrack(int r,int n,char[][] board){
        if(r==n){
            List<String> res = new ArrayList<>();
            
            for(char[] c:board){
                StringBuilder sb = new StringBuilder();
                for(char i:c){
                    sb.append(i);
                }
                res.add(sb.toString());
            }
            ans.add(res);
            return;
        }

        for(int i=0;i<n;i++){
            if(col.contains(i) || posDiag.contains(r+i) || negDiag.contains(r-i)){
                continue;
            }
            board[r][i]='Q';
            col.add(i);
            posDiag.add(r+i);
            negDiag.add(r-i);
            backtrack(r+1,n,board);
            col.remove(i);
            posDiag.remove(r+i);
            negDiag.remove(r-i);
            board[r][i]='.';
        }
    }
}
