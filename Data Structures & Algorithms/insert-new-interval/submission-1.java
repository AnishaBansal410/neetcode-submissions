class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        int i=0;

        int start = newInterval[0];
        int end = newInterval[1];

        while(i<intervals.length && intervals[i][1]<start){
            ans.add(intervals[i]);
            i++;
        }

        while(i<intervals.length && end>=intervals[i][0]){
            start=Math.min(intervals[i][0],start);
            end=Math.max(end,intervals[i][1]);
            i++;
        }

        ans.add(new int[]{start,end});

        while(i<intervals.length){
            ans.add(intervals[i]);
            i++;
        }

        int[][] arr = new int[ans.size()][2];
        int j=0;

        for(int[] x : ans){
            arr[j++]=x;
        }

        return arr;
    }
}
