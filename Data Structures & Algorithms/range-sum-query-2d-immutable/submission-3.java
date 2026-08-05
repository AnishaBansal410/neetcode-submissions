class NumMatrix {
    int[][] matrix;
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        this.sum=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int left=0,top=0;
                if(i>0){
                    top = sum[i-1][j];
                }
                if(j>0){
                    left=sum[i][j-1];
                }
                sum[i][j] = left+top+matrix[i][j];
                if(i>0 && j>0){
                    sum[i][j]-=sum[i-1][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
       return sum[row2][col2]
                - (row1 > 0 ? sum[row1 - 1][col2] : 0)
                - (col1 > 0 ? sum[row2][col1 - 1] : 0)
                + (row1 > 0 && col1 > 0 ? sum[row1 - 1][col1 - 1] : 0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */