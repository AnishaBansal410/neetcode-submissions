class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i=0;
        while(i<intervals.length && newInterval[0]>intervals[i][1]){
            list.add(intervals[i++]);
        }
        int start=newInterval[0];
        int end=newInterval[1];

        while(i<intervals.length && end>=intervals[i][0]){
            start=Math.min(start,intervals[i][0]);
            end=Math.max(end,intervals[i][1]);
            i++;
        }

        list.add(new int[]{start,end});

        while(i<intervals.length){
            list.add(intervals[i++]);
        }

        int[][] ans = new int[list.size()][2];
        int j=0;
        for(int[] arr : list){
            ans[j++]=arr;
        }
        return ans;
    }
}
