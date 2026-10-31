class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        Arrays.sort(arr);

        int r=0,l=arr.length-1;
        while(l-r>=k){
            if(Math.abs(x-arr[r])>Math.abs(arr[l]-x)){
                r++;
            }
            else{
                l--;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=r;i<=l;i++){
            ans.add(arr[i]);
        }

        return ans;
    }
}