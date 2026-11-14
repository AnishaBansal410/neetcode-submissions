class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<>();

        int i=0;

        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            arr.add(intervals[i++]);
        }

        int start=newInterval[0];
        int end=newInterval[1];

        while(i<intervals.length && intervals[i][0]<=end){
            start=Math.min(start,intervals[i][0]);
            end=Math.max(end,intervals[i][1]);
            i++;
        }

        arr.add(new int[]{start,end});

        while(i<intervals.length){
            arr.add(intervals[i++]);
        }

        int[][] ans = new int[arr.size()][2];

        int j=0;

        for(int[] x:arr){
            ans[j++]=x;
        }

        return ans;
    }
}
