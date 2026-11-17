class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max=0;

        for(int i:weights){
            sum+=i;
            max=Math.max(i,max);
        }

        int st = max;
        int end = sum;

        int ans = 0;

        while(st<=end){
            int mid = st+(end-st)/2;

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
        int total=0;

        int i=0;

        while(i<weights.length){
            int j=i;
            int sum=0;

            while(j<weights.length && sum+weights[j]<=cap){
                sum+=weights[j];
                j++;
            }
            total++;
            i=j;

            if(total>days){
                return false;
            }
        }

        return total<=days;
    }
}