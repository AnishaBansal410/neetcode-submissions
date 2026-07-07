class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int[] arr:matrix){
            reverse(arr);
        }
    }

    public static void reverse(int[] arr){
        int i=0,j=arr.length-1;
        while(i<j){
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
            i++;j--;
        }
    }
}
