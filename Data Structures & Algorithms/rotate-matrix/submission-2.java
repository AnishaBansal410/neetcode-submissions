class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        for(int i=0;i<matrix.length;i++){
            int st=0,end=matrix[0].length-1;
            while(st<=end){
                int tmp=matrix[i][st];
                matrix[i][st]=matrix[i][end];
                matrix[i][end]=tmp;
                st++;
                end--;
            }
        }
    }
}
