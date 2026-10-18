class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Arrays.sort(weights);
        int max=0;
        int sum=0;
        for(int i:weights){
            max=Math.max(max,i);
            sum+=i;
        }
        int st=max,end=sum;
        int ans=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isValid(weights,days,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] weights,int days,int cap){
        int currDays=0;
        int i=weights.length-1;

        while(i>=0){
            int j=i;
            int currWeight=0;
            while(j>=0 && currWeight+weights[j]<=cap){
                currWeight+=weights[j];
                j--;
            }
            currDays++;
            i=j;
        }
        if(currDays>days){
            return false;
        }
        return true;
    }
}