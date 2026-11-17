class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k%n;

        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] arr,int st,int end){
        while(st<end){
            int tmp=arr[st];
            arr[st]=arr[end];
            arr[end]=tmp;
            st++;
            end--;
        }
    }
}