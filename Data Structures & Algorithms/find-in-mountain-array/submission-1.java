/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int st=0,end=mountainArr.length()-1;
        int peak=0;
        while(st<end){
            int mid = st+(end-st)/2;

            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                end=mid;
            }
            else{
                st=mid+1;
            }
        }
        peak=st;

        st=0;
        end=peak;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(mountainArr.get(mid)==target){
                return mid;
            }
            if(mountainArr.get(mid)<target){
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        st=peak+1;
        end=mountainArr.length()-1;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(mountainArr.get(mid)==target){
                return mid;
            }
            if(mountainArr.get(mid)<target){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        return -1;
    }
}