class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;

        sort(nums,0,n-1);
        return nums;
    }
    public void sort(int[] a, int l,int r){
        if(l<r){
            int mid= l + (r-l)/2;
            sort(a,l,mid);
            sort(a,mid+1,r);
            merge(a,l,mid,r);
        }       
    }
    public void merge(int[] a,int l,int m,int r){
        int[] b = new int[m-l+1];
        int[] c = new int[r-m];
        for(int i=0;i<m-l+1;i++){
            b[i]=a[l+i];
        }
        for(int i=0;i<r-m;i++){
            c[i]=a[m+1+i];
        }
        int i=0,j=0,k=l;

        while(i<m-l+1 && j<r-m){

            if(b[i]<=c[j]){
                a[k] = b[i];
                i++;k++;
            }
            else{
                a[k]=c[j];
                j++;k++;
            }
        }
        while(i<m-l+1){
            a[k] = b[i];
            i++;k++;
        }
        while(j<r-m){
            a[k]=c[j];
            j++;k++;
        }
    }
}