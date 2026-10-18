class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int i=0,j=arr.length-1;

        while(j-i>=k){
            if(Math.abs(arr[i]-x)>Math.abs(arr[j]-x)){
                i++;
            }
            else{
                j--;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int r=i;r<=j;r++){
            ans.add(arr[r]);
        }
        return ans;
    }
}