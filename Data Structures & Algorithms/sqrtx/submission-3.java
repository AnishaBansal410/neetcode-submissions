class Solution {
    public int mySqrt(int x) {
        int ans=0;
        int st=0,end=x;

        while(st<=end){
            int mid = st+(end-st)/2;
            if((long)mid*mid==x){
                return mid;
            }
            if((long)mid*mid<x){
                ans=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return ans;
    }
}