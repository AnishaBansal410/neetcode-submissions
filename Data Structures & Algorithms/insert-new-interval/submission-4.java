class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<>();

        int i=0;

        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            arr.add(intervals[i++]);
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while(i<intervals.length && intervals[i][0]<=end){
            end=Math.max(intervals[i][1],end);
            start=Math.min(intervals[i][0],start);
            i++;
        }

        arr.add(new int[]{start,end});

        while(i<intervals.length){
            arr.add(intervals[i++]);
        }

        int[][] ans = new int[arr.size()][2];
        int j=0;

        for(int[] interval:arr){
            ans[j++]=interval;
        }

        return ans;
    }
}
