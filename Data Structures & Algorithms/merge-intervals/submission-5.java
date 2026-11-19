class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> arr = new ArrayList<>();

        int i=0;

        while(i<intervals.length){
            int j=i+1;
            int end=intervals[i][1];
            while(j<intervals.length && intervals[j][0]<=end){
                end=Math.max(end,intervals[j][1]);
                j++;
            }

            arr.add(new int[]{intervals[i][0],end});
            i=j;
        }
        int[][] ans = new int[arr.size()][2];
        int j=0;

        for(int[] x:arr){
            ans[j++]=x;
        }

        return ans;
    }
}
