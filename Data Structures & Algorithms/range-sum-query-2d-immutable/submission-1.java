class NumMatrix {
    int[][] matrix;
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        this.sum=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            this.sum[i][0]=matrix[i][0];
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                this.sum[i][j]=this.sum[i][j-1]+matrix[i][j];
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            for(int i=1;i<matrix.length;i++){
                this.sum[i][j]=this.sum[i-1][j]+this.sum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = this.sum[row2][col2];
        int up = (row1 > 0) ? this.sum[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? this.sum[row2][col1 - 1] : 0;
        int overlap = (row1 > 0 && col1 > 0) ? this.sum[row1 - 1][col1 - 1] : 0;

        return total - up - left + overlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */