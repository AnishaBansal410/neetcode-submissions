class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);

        if(intervals.length==0){
            return 0;
        }

        int removals=0;

        int currEnd=Integer.MIN_VALUE;

        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<currEnd){
                removals++;
            }
            else{
                currEnd=intervals[i][1];
            }
        }

        return removals;
    }
}
